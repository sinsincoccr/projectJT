package com.project.controller;

import com.project.domain.*;
import com.project.service.KakaoService;
import com.project.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class KakaopayController {

    private KakaoPayReadyVO kakaoPayReadyVO;
    private KakaoPayApprovalVO kakaoPayApprovalVO;
    private final KakaoService kakaoService;
    private final StoreService storeService;
    private static final String HOST = "https://kapi.kakao.com";

    @RequestMapping("/kakaopayReady")
    @ResponseBody
    public ResponseEntity<KakaoPayReadyVO> kakaopayReady(HttpSession session) {
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        Long product_no = (Long) session.getAttribute("product_no");
        log.info("product_no : {}", product_no);
        log.info("user_no : {}", member.getUser_no());

        // 카카오 폼 저장
        kakaoService.addKakaopayForm(member.getUser_no(), product_no);

        RestTemplate restTemplate = new RestTemplate();
        StoreProductVO storeProductVO = storeService.getProduct(product_no);

        log.info("member 로그 확인 : " + member);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "a61844a7345a6312ea7adbc0755fdf23");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("cid", "TC0ONETIME");
        log.info("id로그 확인 : " + String.valueOf(member.getUser_no()));
        params.add("partner_order_id", String.valueOf(member.getUser_no()));
        params.add("partner_user_id", String.valueOf(member.getUser_no()));
        params.add("item_name", String.valueOf(storeProductVO.getProduct_title()));
        params.add("quantity", "1");
        params.add("total_amount", String.valueOf(storeProductVO.getProduct_price()));
        params.add("tax_free_amount", "0");
        params.add("approval_url", "http://localhost:8080/kakaoPaySuccess");
        params.add("cancel_url", "http://localhost:8080/kakaoPayCancel");
        params.add("fail_url", "http://localhost:8080/kakaoPaySuccessFail");

        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<>(params, headers);

        try {
            kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);
            log.info("성공: " + kakaoPayReadyVO);

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(kakaoPayReadyVO);

        } catch (RestClientException | URISyntaxException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/kakaoPaySuccess")
    public String kakaoPaySuccess( @RequestParam("pg_token") String pg_token, Model model, HttpSession session) {
        log.info("kakaoPaySuccess GET request");
        log.info("kakaoPaySuccess pg_token : " + pg_token);

        model.addAttribute("info", kakaoPayInfo(pg_token, session));
        return "store/kakaoPaySuccess";
    }

    public KakaoPayApprovalVO kakaoPayInfo(String pg_token, HttpSession session) {
        log.info("KakaoPayInfoVO............................................");
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        Long product_no = (Long) session.getAttribute("product_no");
        StoreProductVO storeProductVO = storeService.getProduct(product_no);

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "a61844a7345a6312ea7adbc0755fdf23");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("tid", kakaoPayReadyVO.getTid());
        params.add("partner_order_id", String.valueOf(member.getUser_no()));
        params.add("partner_user_id", String.valueOf(member.getUser_no()));
        params.add("pg_token", pg_token);
        params.add("total_amount", String.valueOf(storeProductVO.getProduct_price()));

        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);

        try {
            kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayApprovalVO.class);
            log.info("kakaoPayApprovalVO :" + kakaoPayApprovalVO);

            // DB 등록처리
            log.info("폼 저장 파람 :" + params);
            log.info("폼 저장 제품번호용 :" + storeProductVO);

            return kakaoPayApprovalVO;

        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }
}

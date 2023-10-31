package com.project.controller;

import com.project.domain.MemberVO;
import com.project.domain.OrderListVO;
import com.project.domain.StoreProductVO;
import com.project.service.KakaoService;
import com.project.service.MemberService;
import com.project.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MemberController {

    private final MemberService memberService;
    private final KakaoService kakaoService;
    private final StoreService storeService;

    //회원가입
    @GetMapping("/createId")
    public String create(Model model){
        model.addAttribute("member", new MemberVO());
        return "member/createId";
    }

    @PostMapping("/createId")
    public String newPro(MemberVO member) {
        log.info("member : {}", member);
        MemberVO savedMember = memberService.createId(member);
        log.info("savedMember : {}", savedMember);
        return "redirect:/mainPage"; // 회원 상세 페이지로 이동
    }

    //아이디 중복체크
    @PostMapping("/idCheck")
    @ResponseBody
    public int idCheck(@RequestParam("id") String id) {

        int cnt = memberService.idCheck(id);
        return cnt;

    }


    //마이페이지
    @GetMapping("/myPage")
    public String myPage(Model model, HttpSession session){
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        model.addAttribute("member", member);

        List<OrderListVO> orderList = kakaoService.getOrderList(member.getUser_no());
        model.addAttribute("orderList", orderList);

        List<StoreProductVO> productList = new ArrayList<>();
        for (OrderListVO order : orderList) {
            Long product_no = order.getProduct_no();
            StoreProductVO product = storeService.getProduct(product_no);
            productList.add(product);
        }

        model.addAttribute("productList", productList);

        return "member/myPage";
    }


    //정보 수정
    @GetMapping("/modifyId")
    public String modify(Model model, HttpSession session){
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        model.addAttribute("member", member);
        return "member/modifyId";
    }

    @PostMapping("/modifyId")
    public String modifyPro(@ModelAttribute MemberVO member) {
        log.info("member : {}", member);
        memberService.modifyId(member);
        return "redirect:/mainPage"; // 회원 상세 페이지로 이동
    }









}

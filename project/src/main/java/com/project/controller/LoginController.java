package com.project.controller;

import com.project.aspect.TokenRequired;
import com.project.domain.MemberVO;
import com.project.service.MemberService;
import com.project.service.SeekerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.project.security.SecurityService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.http.HttpHeaders;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {
    private final MemberService memberService;
    private final SecurityService securityService;



    @RequestMapping("/")
    public String home(@ModelAttribute MemberVO member, HttpSession session, HttpServletRequest request, Model model) {

        model.addAttribute("member", new MemberVO());
        // 세션 없으면 로그인로 이동
        if (session == null) {
            // 여기서 세션에 null 값을 넣어줍니다.
            session.setAttribute("loginMember", null);
            log.info("session null");
            return "login/login";
        }
        return "login/login";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute MemberVO member, Model model){
        model.addAttribute("member", new MemberVO());
        return "login";
    }

    @PostMapping("/login")
    public String loginPro(@ModelAttribute MemberVO member, HttpSession session, Model model, RedirectAttributes redirectAttributes){
        log.info("member PostMapping : {}", member);

        // 로그인 로직 구현
        MemberVO loginMember = memberService.login(member);
        log.info("loginMember {}", loginMember);
        if(loginMember != null) {
            session.setAttribute("loginMember", loginMember);
            String token = securityService.createToken(loginMember.getUser_id(), (2 * 1000 * 60));
            redirectAttributes.addFlashAttribute("token", token);
            log.info("token : {}", token);

            return "redirect:/createToken"; // 로그인 후 홈으로 이동


        } else {  // 알럿창 띄우기 추가
            model.addAttribute("loginFail", true);
            // 로그인 실패 시 알림 창 띄우기 위해 Flash Attributes 사용
            session.setAttribute("loginFailMessage", "");

            return "redirect:/"; // 로그인 실패 시 폼 html 보여주기
        }
    }

    @GetMapping("/createToken")
    public String createToken() {
        return "/login/createToken";
    }


    // 로그아웃 요청
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login/logout";
    }







}

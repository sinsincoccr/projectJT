package com.project.controller;

import com.project.domain.MemberVO;
import com.project.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MemberController {

    private final MemberService memberService;

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












}

package com.project.controller;

import com.project.domain.MemberVO;
import com.project.domain.SeekerVO;
import com.project.service.MemberService;
import com.project.service.SeekerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SeekerController {
    private final SeekerService seekerService;
    private final MemberService memberService;

    // 글작성 폼
    @GetMapping("/writeSeeker")
    public String addSeeker(@ModelAttribute SeekerVO seekerVO, Model model) {
        model.addAttribute( "seeker", seekerVO);
        return "jobSeeker/writeSeeker";
    }

    @PostMapping("/writeSeeker")
    public String addSeekerForm(@ModelAttribute SeekerVO seekerVO, Model model, HttpSession session, RedirectAttributes rttr) {
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        String seekerCategory = seekerVO.getSeeker_category();
        rttr.addAttribute("seekerCategory", seekerCategory);
        // Set the user_id field in offerVO
        seekerVO.setUser_no(member.getUser_no());
        seekerVO.setUser_name(member.getUser_name());
        log.info("seekerVO ::::: {}", seekerVO);
        seekerService.addSeekerForm(seekerVO);
        return "redirect:/jobSeeker/{seekerCategory}";
    }

    //정보 확인
    @GetMapping("/seekerInfo")
    public String seekerInfo(Long seeker_no , Model model){
        log.info("seeker_no : {}", seeker_no);
        SeekerVO seekerVO = seekerService.getSeeker(seeker_no);
        MemberVO memberVO = memberService.getMember(Long.valueOf(seekerVO.getUser_no()));
        model.addAttribute( "seeker", seekerVO);
        model.addAttribute( "user", memberVO);
        return "jobSeeker/SeekerInfo";
    }

    @GetMapping("/updateSeeker")
    public String seekerUpdate(Long seeker_no, Model model) {
        log.info("seeker_no : {}", seeker_no);
        SeekerVO seekerVO = seekerService.getSeeker(seeker_no);
        model.addAttribute( "seeker", seekerVO);
        return "jobSeeker/updateSeeker";
    }

    @PostMapping("/updateSeeker")
    public String seekerUpdatePro(Long seeker_no , @ModelAttribute SeekerVO seekerVO) {
        log.info("seeker_no : {}", seeker_no);
        seekerService.updateSeeker(seekerVO);
        return "redirect:/seekerInfo?seeker_no=" + seeker_no;
    }

    // 글 삭제
    @PostMapping("/deleteSeeker")
    public String deletePro(@RequestParam Long seeker_no) {
        log.info("delete seeker_no : {}", seeker_no);
        seekerService.deleteSeeker(seeker_no);
        return "redirect:/mainPage";
    }
}

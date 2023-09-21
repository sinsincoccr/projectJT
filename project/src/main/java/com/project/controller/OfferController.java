package com.project.controller;


import com.project.domain.MemberVO;
import com.project.domain.OfferVO;
import com.project.service.MemberService;
import com.project.service.OfferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class OfferController {
    private final OfferService offerService;
    private final MemberService memberService;

    // 글작성 폼
    @GetMapping("/writeOffer")
    public String addOffer(@ModelAttribute OfferVO offerVO, Model model) {
        model.addAttribute( "offer", offerVO);
        return "jobOffer/writeOffer";
    }

    @PostMapping("/writeOffer")
    public String addOfferForm(@ModelAttribute OfferVO offerVO, Model model, HttpSession session, RedirectAttributes rttr) {
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        String offerCategory = offerVO.getOffer_category();
        rttr.addAttribute("offerCategory", offerCategory);
        // Set the user_id field in offerVO
        offerVO.setUser_no(member.getUser_no());

        log.info("offervo ::::: {}", offerVO);
        offerService.addOfferForm(offerVO);
        return "redirect:/jobOffer/{offerCategory}";
    }




    //쇼 정보 확인
    @GetMapping("/offerInfo")
    public String offerInfo(Long offer_no , Model model){
        log.info("offer_no : {}", offer_no);
        OfferVO offerVO = offerService.getOffer(offer_no);
        MemberVO memberVO = memberService.getMember(Long.valueOf(offerVO.getUser_no()));
        model.addAttribute( "offer", offerVO);
        model.addAttribute( "member", memberVO);
        return "jobOffer/offerInfo";
    }










}

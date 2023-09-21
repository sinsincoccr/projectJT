package com.project.controller;


import com.project.domain.*;
import com.project.dto.PageDTO;
import com.project.dto.Pager;
import com.project.service.BoardService;
import com.project.service.OfferService;
import com.project.service.SeekerService;
import com.project.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainPageController {
    private final OfferService offerService;
    private final SeekerService seekerService;
    private final StoreService storeService;
    private final BoardService boardService;

    //메인페이지 이동
    @GetMapping("/mainPage")
    public String mainPage(Pager pager, Model model, Model model2, Model model3, Model model4, Model model5, Model model6, Model model7, HttpSession session) {
        log.info("session.loginMember : {} " , session.getAttribute("loginMember"));
        model.addAttribute("member", new MemberVO());
        List<OfferVO> offerVOList = offerService.findEditer();
        List<SeekerVO> seekerVOList = seekerService.findEditerSeeker();
        model2.addAttribute("offer", offerVOList);
        model3.addAttribute("seeker", seekerVOList);
        List<BoardVO> boardVOFree = boardService.getFreeBoardListWithPaging(new Pager());
        List<BoardVO> boardVOFeed = boardService.getFeedbackBoardListWithPaging(new Pager());
        List<BoardVO> boardVORevenue = boardService.getRevenueBoardListWithPaging(new Pager());
        List<BoardVO> boardVOTax = boardService.getTaxBoardListWithPaging(new Pager());

        log.info("pager : {}", pager);

        model4.addAttribute("boardVOFree", boardVOFree);
        model5.addAttribute("boardVOFeed", boardVOFeed);
        model6.addAttribute("boardVORevenue", boardVORevenue);
        model7.addAttribute("boardVOTax", boardVOTax);
        return "mainPage";
    }

    //구인 페이지 이동
    @GetMapping("/jobOffer/editer")
    public String editer(Model model, Model model2){
        model.addAttribute("member", new MemberVO());
        List<OfferVO> offerVOList = offerService.findEditer();
        model2.addAttribute("offer", offerVOList);
        return "jobOffer/editer";
    }


    @GetMapping("/jobOffer/thumbnailer")
    public String thumbnailer(Model model, Model model2){
        model.addAttribute("member", new MemberVO());
        List<OfferVO> offerVOList = offerService.findThumbnailer();
        model2.addAttribute("offer", offerVOList);
        return "jobOffer/thumbnailer";
    }

    @GetMapping("/jobOffer/sdCharacter")
    public String sdCharacter(Model model, Model model2){
        model.addAttribute("member", new MemberVO());
        List<OfferVO> offerVOList = offerService.findSdCharacter();
        model2.addAttribute("offer", offerVOList);
        return "jobOffer/sdCharacter";
    }

    @GetMapping("/jobOffer/virtual")
    public String virtual(Model model, Model model2){
        model.addAttribute("member", new MemberVO());
        List<OfferVO> offerVOList = offerService.findVirtual();
        model2.addAttribute("offer", offerVOList);
        return "jobOffer/virtual";
    }

    @GetMapping("/jobOffer/camaraMan")
    public String camaraMan(Model model, Model model2){
        model.addAttribute("member", new MemberVO());
        List<OfferVO> seekerVOList = offerService.findCamaraMan();
        model2.addAttribute("offer", seekerVOList);
        return "jobOffer/camaraMan";
    }


    //구인 페이지 이동
    @GetMapping("/jobSeeker/editerSeeker")
    public String editerSeeker(Model model, Model model2){
        model.addAttribute("member", new MemberVO());
        List<SeekerVO> seekerVOList = seekerService.findEditerSeeker();
        model2.addAttribute("seeker", seekerVOList);
        return "jobSeeker/editerSeeker";
    }


    @GetMapping("/jobSeeker/thumbnailerSeeker")
    public String thumbnailerSeeker(Model model, Model model2){
        model.addAttribute("member", new MemberVO());
        List<SeekerVO> seekerVOList = seekerService.findThumbnailerSeeker();
        model2.addAttribute("seeker", seekerVOList);
        return "jobSeeker/thumbnailerSeeker";
    }

    @GetMapping("/jobSeeker/sdCharacterSeeker")
    public String sdCharacterSeeker(Model model, Model model2){
        model.addAttribute("member", new MemberVO());
        List<SeekerVO> seekerVOList = seekerService.findSdCharacterSeeker();
        model2.addAttribute("seeker", seekerVOList);
        return "jobSeeker/sdCharacterSeeker";
    }

    @GetMapping("/jobSeeker/virtualSeeker")
    public String virtualSeeker(Model model, Model model2){
        model.addAttribute("member", new MemberVO());
        List<SeekerVO> seekerVOList = seekerService.findVirtualSeeker();
        model2.addAttribute("seeker", seekerVOList);
        return "jobSeeker/virtualSeeker";
    }

    @GetMapping("/jobSeeker/camaraManSeeker")
    public String camaraManSeeker(Model model, Model model2){
        model.addAttribute("member", new MemberVO());
        List<SeekerVO> seekerVOList = seekerService.findCamaraManSeeker();
        model2.addAttribute("seeker", seekerVOList);
        return "jobSeeker/camaraManSeeker";
    }

    // 스토어 바로가기
    @GetMapping("/store/premierProStore")
    public String premierProStore(Model model){
        List<StoreProductVO> storeProductVO = storeService.findPremierProStore();
        model.addAttribute("product", storeProductVO);
        return "store/premierProStore";
    }


    @GetMapping("/store/finalCutStore")
    public String finalCutStore(Model model){
        List<StoreProductVO> storeProductVO = storeService.findFinalCutStore();
        model.addAttribute("product", storeProductVO);
        return "store/finalCutStore";
    }

    @GetMapping("/store/imageStore")
    public String imageStore(Model model){
        List<StoreProductVO> storeProductVO = storeService.findImageStore();
        model.addAttribute("product", storeProductVO);
        return "store/imageStore";
    }

    @GetMapping("/store/powerBannerStore")
    public String powerBannerStore(Model model){
        List<StoreProductVO> storeProductVO = storeService.findPowerBannerStore();
        model.addAttribute("product", storeProductVO);
        return "store/powerBannerStore";
    }

    @GetMapping("/board/freeBoard")
    public String freeBoard(Pager pager, Model model){
        List<BoardVO> boardVO = boardService.getFreeBoardListWithPaging(pager);
        log.info("pager : {}", pager);
        model.addAttribute("pageDTO", new PageDTO(pager, boardService.getFreeBoard(pager)));
        model.addAttribute("board", boardVO);
        return "/board/freeBoard";
    }



    @GetMapping("/board/feedbackBoard")
    public String feedbackBoard(Pager pager, Model model){
        log.info("pager : {}", pager);
        model.addAttribute("pageDTO", new PageDTO(pager, boardService.getFeedbackBoard(pager)));
        model.addAttribute("board", boardService.getFeedbackBoardListWithPaging(pager));


        return "/board/feedbackBoard";
    }

    @GetMapping("/board/revenueBoard")
    public String revenueBoard(Pager pager, Model model){
        List<BoardVO> boardVO = boardService.getRevenueBoardListWithPaging(pager);
        log.info("pager : {}", pager);
        model.addAttribute("pageDTO", new PageDTO(pager, boardService.getRevenueBoard(pager)));
        model.addAttribute("board", boardVO);


        return "/board/revenueBoard";
    }

    @GetMapping("/board/taxBoard")
    public String taxBoard(Pager pager, Model model){
        List<BoardVO> boardVO = boardService.getTaxBoardListWithPaging(pager);
        log.info("pager : {}", pager);
        model.addAttribute("pageDTO", new PageDTO(pager, boardService.getTaxBoard(pager)));
        model.addAttribute("board", boardVO);


        return "/board/taxBoard";
    }

}

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
    public String editer(Pager pager ,Model model, Model model2){
        List<OfferVO> offerVO = offerService.getEditorListWithPaging(pager);
        log.info("pager : {}", pager);
        model.addAttribute("pageDTO", new PageDTO(pager, offerService.findEditerCount(pager)));
        model.addAttribute("offer", offerVO);

        return "jobOffer/editer";
    }


    @GetMapping("/jobOffer/thumbnailer")
    public String thumbnailer(Pager pager ,Model model, Model model2){
        List<OfferVO> offerVO = offerService.getThumbnailerListWithPaging(pager);
        log.info("pager : {}", pager);
        model.addAttribute("pageDTO", new PageDTO(pager, offerService.findThumbnailerCount(pager)));
        model.addAttribute("offer", offerVO);


        return "jobOffer/thumbnailer";
    }

    @GetMapping("/jobOffer/sdCharacter")
    public String sdCharacter(Pager pager ,Model model, Model model2){
        List<OfferVO> offerVO = offerService.getSdCharacterListWithPaging(pager);
        log.info("pager : {}", pager);
        model.addAttribute("pageDTO", new PageDTO(pager, offerService.findSdCharacterCount(pager)));
        model.addAttribute("offer", offerVO);


        return "jobOffer/sdCharacter";
    }

    @GetMapping("/jobOffer/virtual")
    public String virtual(Pager pager ,Model model, Model model2){
        List<OfferVO> offerVO = offerService.getVirtualListWithPaging(pager);
        log.info("pager : {}", pager);
        model.addAttribute("pageDTO", new PageDTO(pager, offerService.findVirtualCount(pager)));
        model.addAttribute("offer", offerVO);


        return "jobOffer/virtual";
    }

    @GetMapping("/jobOffer/camaraMan")
    public String camaraMan(Pager pager ,Model model, Model model2){
        List<OfferVO> offerVO = offerService.getCamaraManListWithPaging(pager);
        log.info("pager : {}", pager);
        model.addAttribute("pageDTO", new PageDTO(pager, offerService.findCamaraManCount(pager)));
        model.addAttribute("offer", offerVO);
        return "jobOffer/camaraMan";
    }


    //구인 페이지 이동
    @GetMapping("/jobSeeker/editerSeeker")
    public String editerSeeker(Pager pager ,Model model, Model model2){
        //List<SeekerVO> seekerVO = seekerService.findEditerSeeker();
        //model.addAttribute("member", new MemberVO());
        //model2.addAttribute("seeker", seekerVO);
        List<SeekerVO> seekerVO = seekerService.getEditerSeekerListWithPaging(pager);
        log.info("pager : {}", pager);
        model.addAttribute("pageDTO", new PageDTO(pager, seekerService.findEditerSeekerCount(pager)));
        model.addAttribute("seeker", seekerVO);

        return "jobSeeker/editerSeeker";
    }


    @GetMapping("/jobSeeker/thumbnailerSeeker")
    public String thumbnailerSeeker(Pager pager ,Model model, Model model2){
        //model.addAttribute("member", new MemberVO());
        //List<SeekerVO> seekerVOList = seekerService.findThumbnailerSeeker();
        //model2.addAttribute("seeker", seekerVOList);
        List<SeekerVO> seekerVO = seekerService.getThumbnailerSeekerListWithPaging(pager);
        log.info("pager : {}", pager);
        model.addAttribute("pageDTO", new PageDTO(pager, seekerService.findThumbnailerSeekerCount(pager)));
        model.addAttribute("seeker", seekerVO);
        return "jobSeeker/thumbnailerSeeker";
    }

    @GetMapping("/jobSeeker/sdCharacterSeeker")
    public String sdCharacterSeeker(Pager pager ,Model model, Model model2){
        //model.addAttribute("member", new MemberVO());
        //List<SeekerVO> seekerVOList = seekerService.findSdCharacterSeeker();
        //model2.addAttribute("seeker", seekerVOList);
        List<SeekerVO> seekerVO = seekerService.getSdCharacterSeekerListWithPaging(pager);
        log.info("pager : {}", pager);
        model.addAttribute("pageDTO", new PageDTO(pager, seekerService.findSdCharacterSeekerCount(pager)));
        model.addAttribute("seeker", seekerVO);
        return "jobSeeker/sdCharacterSeeker";
    }

    @GetMapping("/jobSeeker/virtualSeeker")
    public String virtualSeeker(Pager pager ,Model model, Model model2){
        //model.addAttribute("member", new MemberVO());
        //List<SeekerVO> seekerVOList = seekerService.findVirtualSeeker();
        //model2.addAttribute("seeker", seekerVOList);
        List<SeekerVO> seekerVO = seekerService.getVirtualSeekerListWithPaging(pager);
        log.info("pager : {}", pager);
        model.addAttribute("pageDTO", new PageDTO(pager, seekerService.findVirtualSeekerCount(pager)));
        model.addAttribute("seeker", seekerVO);
        return "jobSeeker/virtualSeeker";
    }

    @GetMapping("/jobSeeker/camaraManSeeker")
    public String camaraManSeeker(Pager pager ,Model model, Model model2){
        //model.addAttribute("member", new MemberVO());
        //List<SeekerVO> seekerVOList = seekerService.findCamaraManSeeker();
        //model2.addAttribute("seeker", seekerVOList);
        List<SeekerVO> seekerVO = seekerService.getCamaraManSeekerListWithPaging(pager);
        log.info("pager : {}", pager);
        model.addAttribute("pageDTO", new PageDTO(pager, seekerService.findCamaraManSeekerCount(pager)));
        model.addAttribute("seeker", seekerVO);
        return "jobSeeker/camaraManSeeker";
    }

    // 스토어 바로가기
    @GetMapping("/store/premierProStore")
    public String premierProStore(Pager pager,Model model){
        //List<StoreProductVO> storeProductVO = storeService.findPremierProStore();
        //model.addAttribute("product", storeProductVO);
        List<StoreProductVO> storeProductVO = storeService.getPremierProStoreListWithPaging(pager);
        log.info("pager : {}", pager);
        model.addAttribute("pageDTO", new PageDTO(pager, storeService.findPremierProStoreCount(pager)));
        model.addAttribute("storeProduct", storeProductVO);
        return "store/premierProStore";
    }


    @GetMapping("/store/finalCutStore")
    public String finalCutStore(Pager pager,Model model){
        List<StoreProductVO> storeProductVO = storeService.getFinalCutStoreListWithPaging(pager);
        log.info("pager : {}", pager);
        model.addAttribute("pageDTO", new PageDTO(pager, storeService.findFinalCutStoreCount(pager)));
        model.addAttribute("storeProduct", storeProductVO);
        return "store/finalCutStore";
    }

    @GetMapping("/store/imageStore")
    public String imageStore(Pager pager,Model model){
        List<StoreProductVO> storeProductVO = storeService.getImageStoreListWithPaging(pager);
        log.info("pager : {}", pager);
        model.addAttribute("pageDTO", new PageDTO(pager, storeService.findImageStoreCount(pager)));
        model.addAttribute("storeProduct", storeProductVO);
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
        return "board/freeBoard";
    }



    @GetMapping("/board/feedbackBoard")
    public String feedbackBoard(Pager pager, Model model){
        log.info("pager : {}", pager);
        model.addAttribute("pageDTO", new PageDTO(pager, boardService.getFeedbackBoard(pager)));
        model.addAttribute("board", boardService.getFeedbackBoardListWithPaging(pager));


        return "board/feedbackBoard";
    }

    @GetMapping("/board/revenueBoard")
    public String revenueBoard(Pager pager, Model model){
        List<BoardVO> boardVO = boardService.getRevenueBoardListWithPaging(pager);
        log.info("pager : {}", pager);
        model.addAttribute("pageDTO", new PageDTO(pager, boardService.getRevenueBoard(pager)));
        model.addAttribute("board", boardVO);


        return "board/revenueBoard";
    }

    @GetMapping("/board/taxBoard")
    public String taxBoard(Pager pager, Model model){
        List<BoardVO> boardVO = boardService.getTaxBoardListWithPaging(pager);
        log.info("pager : {}", pager);
        model.addAttribute("pageDTO", new PageDTO(pager, boardService.getTaxBoard(pager)));
        model.addAttribute("board", boardVO);


        return "board/taxBoard";
    }

}

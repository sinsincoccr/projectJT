package com.project.controller;

import com.project.domain.BoardVO;
import com.project.domain.MemberVO;
import com.project.domain.OfferVO;
import com.project.dto.PageDTO;
import com.project.dto.Pager;
import com.project.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    // 글작성 폼
    @GetMapping("/add")
    public String addForm(@ModelAttribute BoardVO board, Model model) {
        model.addAttribute( "board", board);
        log.info("##########getboard");
        return "board/add";
    }
    // 글작성 처리
    @PostMapping("/add")
    public String addPro(@ModelAttribute BoardVO board, Model model, HttpSession session, RedirectAttributes rttr) {
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        String commCategory = board.getComm_category();
        rttr.addAttribute("commCategory", commCategory);
        board.setUser_no(member.getUser_no());
        log.info("##########postboard before");
        boardService.add(board);
        log.info("##########postboard after");
        return "redirect:/board/{commCategory}";
    }
    /*

*/
    //상세 페이지
    @GetMapping("/{comm_no}")
    public String detail(@PathVariable Long comm_no, Model model) {
        log.info("detail comm_no : {}", comm_no);
        model.addAttribute("board", boardService.getBoard(comm_no));
        return "board/detail";
    }

    //쇼 정보 확인
    @GetMapping("/boardInfo")
    public String boardInfo(Long comm_no , Model model){
        log.info("comm_no : {}", comm_no);
        BoardVO boardVO = boardService.getBoard(comm_no);
        model.addAttribute( "board", boardVO);
        return "board/boardInfo";
    }






}

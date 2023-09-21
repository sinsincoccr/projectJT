package com.project.service;


import com.project.domain.BoardVO;
import com.project.dto.Pager;

import java.util.List;

public interface BoardService {
    // 글 등록 처리
    void add(BoardVO board);
    // 글 목록 가져오기
    List<BoardVO> getFreeBoardListWithPaging(Pager pager);
    // 글 목록 가져오기
    List<BoardVO> getFeedbackBoardListWithPaging(Pager pager);
    // 글 목록 가져오기
    List<BoardVO> getRevenueBoardListWithPaging(Pager pager);
    // 글 목록 가져오기
    List<BoardVO> getTaxBoardListWithPaging(Pager pager);
    // 글 전체 개수 (검색 기능 포함)
    Long getFreeBoard(Pager pager);
    // 글 전체 개수 (검색 기능 포함)
    Long getFeedbackBoard(Pager pager);
    // 글 전체 개수 (검색 기능 포함)
    Long getRevenueBoard(Pager pager);
    // 글 전체 개수 (검색 기능 포함)
    Long getTaxBoard(Pager pager);
    // 글 한개 정보 가져오기
    BoardVO getBoard(Long comm_no);
}

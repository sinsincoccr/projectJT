package com.project.service;


import com.project.domain.BoardVO;
import com.project.domain.OfferVO;
import com.project.dto.Pager;

import java.util.List;

public interface BoardService {
    // 글 등록 처리
    void add(BoardVO board);
    // 글 목록 가져오기
    List<BoardVO> getFreeBoardListWithPaging(Pager pager);
    List<BoardVO> getFeedbackBoardListWithPaging(Pager pager);
    List<BoardVO> getRevenueBoardListWithPaging(Pager pager);
    List<BoardVO> getTaxBoardListWithPaging(Pager pager);

    Long getFreeBoard(Pager pager);
    Long getFeedbackBoard(Pager pager);
    Long getRevenueBoard(Pager pager);
    Long getTaxBoard(Pager pager);
    BoardVO getBoard(Long comm_no);

    void updateView(Long comm_no);
    void updateBoard(BoardVO boardVO);
    void deleteBoard(Long comm_no);
}

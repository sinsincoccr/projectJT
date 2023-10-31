package com.project.repository;


import com.project.domain.BoardVO;
import com.project.domain.OfferVO;
import com.project.dto.Pager;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    // 글 저장
    void add(BoardVO board);
    // 글 리스트 가져오기
    List<BoardVO> getFreeBoardListWithPaging(Pager pager);
    // 글 리스트 가져오기
    List<BoardVO> getFeedbackBoardListWithPaging(Pager pager);
    // 글 리스트 가져오기
    List<BoardVO> getRevenueBoardListWithPaging(Pager pager);
    // 글 리스트 가져오기
    List<BoardVO> getTaxBoardListWithPaging(Pager pager);
    // 글 개수 가져오기
    Long getFreeBoard(Pager pager);
    // 글 개수 가져오기
    Long getFeedbackBoard(Pager pager);
    // 글 개수 가져오기
    Long getRevenueBoard(Pager pager);
    // 글 개수 가져오기
    Long getTaxBoard(Pager pager);

    // 글 한개 조회
    BoardVO getBoard(Long comm_no);

    void updateView(Long comm_no);

    void updateBoard(BoardVO boardVO);

    void deleteBoard(Long comm_no);

}

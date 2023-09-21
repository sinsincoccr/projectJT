package com.project.service;


import com.project.domain.BoardVO;
import com.project.dto.Pager;
import com.project.repository.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;

    @Override
    public void add(BoardVO board) {
        boardMapper.add(board);
    }

    @Override
    public List<BoardVO> getFreeBoardListWithPaging(Pager pager) {
        return boardMapper.getFreeBoardListWithPaging(pager);
    }

    @Override
    public List<BoardVO> getFeedbackBoardListWithPaging(Pager pager) {
        return boardMapper.getFeedbackBoardListWithPaging(pager);
    }

    @Override
    public List<BoardVO> getRevenueBoardListWithPaging(Pager pager) {
        return boardMapper.getRevenueBoardListWithPaging(pager);
    }

    @Override
    public List<BoardVO> getTaxBoardListWithPaging(Pager pager) {
        return boardMapper.getTaxBoardListWithPaging(pager);
    }

    @Override
    public Long getFreeBoard(Pager pager) {
        return boardMapper.getFreeBoard(pager);
    }

    @Override
    public Long getFeedbackBoard(Pager pager) {
        return boardMapper.getFeedbackBoard(pager);
    }

    @Override
    public Long getRevenueBoard(Pager pager) {
        return boardMapper.getRevenueBoard(pager);
    }

    @Override
    public Long getTaxBoard(Pager pager) {
        return boardMapper.getTaxBoard(pager);
    }

    @Override
    public BoardVO getBoard(Long comm_no) {
        return boardMapper.getBoard(comm_no);
    }
}

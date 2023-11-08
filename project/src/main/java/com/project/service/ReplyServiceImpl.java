package com.project.service;


import com.project.domain.ReplyVO;
import com.project.dto.Pager;


import com.project.repository.ReplyMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyMapper replyMapper;

	
	@Override
	public int add(ReplyVO vo) {
		log.info("service add vo : {}", vo);
		int result = replyMapper.insertReply(vo);
		int replyCount = replyMapper.getReplyCount(vo.getComm_no());
		log.info("replyCount : {}", replyCount);
		replyMapper.updateReplyCount(replyCount, vo.getComm_no());
		
		return result;
	}

	@Override
	public ReplyVO get(Long rno) {
		log.info("service get rno : {}", rno);
		return replyMapper.getOneReply(rno);
	}

	@Override
	public List<ReplyVO> getAll() {
		return replyMapper.getAllReply();
	}

	@Override
	public int modify(ReplyVO vo) {
		log.info("service modify vo : {}", vo);
		return replyMapper.updateReply(vo);
	}

	@Override
	public int remove(Long rno) {
		log.info("service delete rno : {}", rno);
		return replyMapper.deleteReply(rno);
	}

	@Override
	public List<ReplyVO> getList(Long comm_no) {
		log.info("service getList bno : {}", comm_no);
		return replyMapper.getReplies(comm_no);
	}

	// 페이징처리 + 댓글 목록 가져오기 
	@Override
	public List<ReplyVO> getListWithPage(Long comm_no, Pager pageInfo) {
		
		return replyMapper.getRepliesWithPage(comm_no, pageInfo);
	}

	@Override
	public int getReplyCount(Long comm_no) {
		return replyMapper.getReplyCount(comm_no);
	}




}

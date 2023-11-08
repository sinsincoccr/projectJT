package com.project.service;


import com.project.domain.ReplyVO;
import com.project.dto.Pager;

import java.util.List;



public interface ReplyService {
	
		// 댓글 등록
		public int add(ReplyVO vo);
		// 댓글 한개 조회 
		public ReplyVO get(Long rno);
		// 댓글 전체 조회
		public List<ReplyVO> getAll();
		// 댓글 수정 
		public int modify(ReplyVO vo);
		// 댓글 삭제
		public int remove(Long rno);
		// 게시글 한개에 해당하는 댓글 목록 가져오기 
		public List<ReplyVO> getList(Long comm_no);
		// 페이징처리 + 댓글 목록 가져오기 
		public List<ReplyVO> getListWithPage(Long comm_no, Pager pageInfo);

		// 본문글에 해당하는 댓글의 전체 개수 구하기 
		public int getReplyCount(Long comm_no);
		
		
	
}

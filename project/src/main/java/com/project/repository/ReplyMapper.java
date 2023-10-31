package com.project.repository;


import com.project.domain.ReplyVO;
import com.project.dto.Pager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {
	
	// 댓글 등록 
		public int insertReply(ReplyVO vo);
		
		// 댓글 한개 가져오기 
		public ReplyVO getOneReply(Long rno);

		public List<ReplyVO> getAllReply();

	// 댓글 수정
		public int updateReply(ReplyVO vo);
		
		// 댓글 삭제 
		public int deleteReply(Long rno);
		
		// 댓글 목록 가져오기(페이징처리X) 
		public List<ReplyVO> getReplies(Long comm_no);
		
		
		// 댓글 목록 가져오기 + 페이징 처리 
		// Mapper 인터페이스 매개변수가 2개 이상일경우 
		// xml에서 매개변수 구분해 사용하기 위해 @Param어노테이션으로 이름을 지정해줘야함.
		public List<ReplyVO> getRepliesWithPage(
				@Param("comm_no") Long comm_no, 
				@Param("pageInfo") Pager pageInfo);
		
		// 본문에 해당하는 댓글 전체 개수 가져오기 
		public int getReplyCount(Long comm_no);

	// 글 댓글 개수 수정하기
	public void updateReplyCount(@Param("replyCount") int replyCount, @Param("comm_no") Long comm_no);
		
		
}

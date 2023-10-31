package com.project.controller;


import com.project.domain.ReplyVO;
import com.project.domain.ReplypageDTO;
import com.project.dto.Pager;
import com.project.service.ReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

//댓글 컨트롤러 

@RestController  // REST 방식 처리해주는 컨트롤러다 (@Controller + @ResponseBody)
@RequestMapping("/replies/*")
@Slf4j
public class ReplyController {
	
	@Autowired
	private ReplyService  replyService;
	
	// 본문글에 해당하는 댓글 목록 요청  
	@GetMapping(value="boardInfo/{comm_no}/{page}",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReplypageDTO> getList(
			@PathVariable("comm_no") Long comm_no,
			@PathVariable("page") int page
			, HttpSession session){

		
		log.info("************ C reply list comm_no : {}", comm_no);
		log.info("************ C reply list page : {}", page);
		
		//List<ReplyVO> list = replyService.getList(bno); // 댓글 페이징처리X
		// 댓글 페이징처리 O : 한페이지에 10개씩 보여주기 
		Pager pageInfo = new Pager(page, 10, 10);
		log.info("************ C reply list pageInfo : {}", pageInfo);
		
		List<ReplyVO> list = replyService.getListWithPage(comm_no, pageInfo);
		// 페이징 처리를 위한 Pager 를 리턴 
		// Pager{댓글list, 본문에 해당하는 댓글목록 전체 개수,...} 
		int replyCount = replyService.getReplyCount(comm_no);
		ReplypageDTO replyDTO = new ReplypageDTO(replyCount, list);
		
		return new ResponseEntity<>(replyDTO, HttpStatus.OK); 
	}
	
	// 댓글 등록 요청 
	@PostMapping(value="new", consumes = "application/json", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> addReply(@RequestBody ReplyVO vo) {
		log.info("***************** C reply new vo : {}", vo);
		
		// DB에 저장해라~ 
		int result = replyService.add(vo);
		// 해당 글의 댓글 카운트 수를 다시 가져와, 전달 
		int replyCount = replyService.getReplyCount(vo.getComm_no());
		
		
		return result == 1 ? 
				new ResponseEntity<String>(replyCount+"", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 댓글 삭제 요청 
	@DeleteMapping("{rno}")
	public ResponseEntity<String> delete(@PathVariable("rno") Long rno) {
		log.info("************** C reply delete rno : {}", rno);
		
		// DB에서 삭제해라~  
		int result = replyService.remove(rno);
		
		return result == 1 ? 
				new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 댓글 수정 요청 
	@PutMapping("{rno}")
	public ResponseEntity<String> modify(
			@PathVariable("rno") Long rno, 
			@RequestBody ReplyVO vo) {
		
		log.info("************ C modify rno : {}", rno);
		log.info("************ C modify vo : {}", vo);
		
		// DB 가서 수정해라~~~ 
		int result = replyService.modify(vo);
		
		return result == 1 ? 
				new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR); 
	}
	
	
	@GetMapping(value="getCount/{comm_no}/{page}", 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReplypageDTO> getCount(
			@PathVariable("comm_no") Long comm_no,
			@PathVariable("page") int page){

		
		Pager pageInfo = new Pager(page, 10, 10);
		log.info("************ C reply list pageInfo : {}", pageInfo);
		
		List<ReplyVO> list = replyService.getListWithPage(comm_no, pageInfo);
		// 페이징 처리를 위한 Pager 를 리턴 
		// Pager{댓글list, 본문에 해당하는 댓글목록 전체 개수,...} 
		int replyCount = replyService.getReplyCount(comm_no);
		ReplypageDTO replyDTO = new ReplypageDTO(replyCount, list);
		
		return new ResponseEntity<>(replyDTO, HttpStatus.OK); 
	}
	
	
	
	
	
	
	
	
	
}

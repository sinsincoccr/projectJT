package com.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class ReplypageDTO {
	private int replyCount; // 본문에 해당하는 댓글의 전체 개수 
	private List<ReplyVO> list; // 페이징처리된 댓글 목록 
}

package com.project.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ReplyVO {
	private Long rno;
	private Long comm_no;
	private String replyContent; 
	private String user_no;
	private String user_name;
	private Timestamp reply_date;
	
	
}

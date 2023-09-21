package com.project.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardVO {
    private Long comm_no;
    private String comm_category;
    private String comm_title;
    private String comm_content;
    private Long comm_views;
    private LocalDateTime regDate;
    private Long user_no;



}

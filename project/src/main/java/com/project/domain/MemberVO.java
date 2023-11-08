package com.project.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberVO {
    private Long user_no;
    private String user_id;
    private String user_pw;
    private String user_name;
    private String user_email;
    private String user_tel;
    private LocalDateTime regDate;
    private String user_state;

}

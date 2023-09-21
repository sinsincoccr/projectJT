package com.project.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SeekerVO {
    private Long seeker_no;
    private String seeker_category;
    private String seeker_title;
    private String seeker_career;
    private String seeker_tools;
    private String seeker_type;
    private Long seeker_case;
    private Long seeker_min;
    private String seeker_portofolio;
    private LocalDateTime regDate;
    private Long user_no;
    private String user_name;


}

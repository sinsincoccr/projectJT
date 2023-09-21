package com.project.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OfferVO {
    private Long offer_no;
    private String offer_category;
    private String offer_company;
    private String offer_title;
    private String offer_career;
    private String offer_tools;
    private String offer_type;
    private Long offer_salary;
    private String offer_content;
    private LocalDateTime regDate;
    private Long user_no;





}

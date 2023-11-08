package com.project.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StoreReviewVO {
    private Long review_no;
    private String review_content;
    private Long review_point;
    private String user_id;
    private Long product_no;
    private LocalDateTime regDate;
}

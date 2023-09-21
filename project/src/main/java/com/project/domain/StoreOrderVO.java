package com.project.domain;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StoreOrderVO {

    private Long order_no;
    private Long user_no;
    private Long product_no;
    private LocalDateTime regDate;




}

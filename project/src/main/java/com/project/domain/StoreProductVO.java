package com.project.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class StoreProductVO {
    private Long product_no;
    private String product_category;
    private MultipartFile product_file; // form 의 name속성 (업로할때만 쓰는 변수)
    private String product_img; // DB 컬럼과 매핑
    private String product_title;
    private String product_content;
    private Long product_price;
    private Integer product_status;
}

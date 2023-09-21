package com.project.repository;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface KakaoMapper {

    void addKakaopayForm(@Param("user_no")Long user_no, @Param("product_no")Long product_no);

}

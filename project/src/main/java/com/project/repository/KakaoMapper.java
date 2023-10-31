package com.project.repository;


import com.project.domain.OfferVO;
import com.project.domain.OrderListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface KakaoMapper {

    void addKakaopayForm(@Param("user_no")Long user_no, @Param("product_no")Long product_no);

    List<OrderListVO> getOrderList(Long user_no);

}

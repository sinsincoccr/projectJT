package com.project.service;

import com.project.domain.OfferVO;
import com.project.domain.OrderListVO;

import java.util.List;

public interface KakaoService {

    void addKakaopayForm(Long user_no, Long product_no);

    List<OrderListVO> getOrderList(Long user_no);



}

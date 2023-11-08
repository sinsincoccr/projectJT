package com.project.service;

import com.project.domain.OfferVO;
import com.project.domain.OrderListVO;
import com.project.repository.KakaoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class KakaoServiceImpl implements  KakaoService{
    private final KakaoMapper kakaoMapper;

    @Override
    public void addKakaopayForm(Long user_no, Long product_no) {
        kakaoMapper.addKakaopayForm(user_no, product_no);
    }

    @Override
    public List<OrderListVO> getOrderList(Long user_no) {
        return kakaoMapper.getOrderList(user_no);
    }


}

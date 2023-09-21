package com.project.service;

import com.project.repository.KakaoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class KakaoServiceImpl implements  KakaoService{
    private final KakaoMapper kakaoMapper;

    @Override
    public void addKakaopayForm(Long user_no, Long product_no) {
        kakaoMapper.addKakaopayForm(user_no, product_no);
    }
}

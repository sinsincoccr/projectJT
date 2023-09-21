package com.project.service;


import com.project.domain.OfferVO;

import java.util.List;

public interface OfferService {

    // 레스토랑 정보 가져오기
    List<OfferVO> findEditer();

    List<OfferVO> findThumbnailer();

    List<OfferVO> findSdCharacter();

    List<OfferVO> findVirtual();

    List<OfferVO> findCamaraMan();

    public OfferVO getOffer(Long offer_no);


    // 글 등록 처리
    void addOfferForm(OfferVO offerVO);
}

package com.project.repository;


import com.project.domain.MemberVO;
import com.project.domain.OfferVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OfferMapper {


    List<OfferVO> findEditer();

    List<OfferVO> findThumbnailer();

    List<OfferVO> findSdCharacter();

    List<OfferVO> findVirtual();

    List<OfferVO> findCamaraMan();

    public OfferVO getOffer(Long offer_no);


    // 글 저장
    void addOfferForm(OfferVO offerVO);
}

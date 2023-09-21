package com.project.service;

import com.project.domain.MemberVO;
import com.project.domain.OfferVO;
import com.project.repository.OfferMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class OfferServiceImpl implements OfferService {

    private final OfferMapper offerMapper;

    @Override
    public List<OfferVO> findEditer() {
        return offerMapper.findEditer();
    }

    @Override
    public List<OfferVO> findThumbnailer() {
        return offerMapper.findThumbnailer();
    }

    @Override
    public List<OfferVO> findSdCharacter() {
        return offerMapper.findSdCharacter();
    }

    @Override
    public List<OfferVO> findVirtual() {
        return offerMapper.findVirtual();
    }

    @Override
    public List<OfferVO> findCamaraMan() {
        return offerMapper.findCamaraMan();
    }

    @Override
    public OfferVO getOffer(Long offer_no) {
        OfferVO offerVO = offerMapper.getOffer(offer_no);
        return offerVO;
    }


    @Override
    public void addOfferForm(OfferVO offerVO) {
        offerMapper.addOfferForm(offerVO);
    }






}

package com.project.service;

import com.project.domain.BoardVO;
import com.project.domain.MemberVO;
import com.project.domain.OfferVO;
import com.project.dto.Pager;
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
    public Long findEditerCount(Pager pager) {
        return offerMapper.findEditerCount(pager);
    }

    @Override
    public List<OfferVO> getEditorListWithPaging(Pager pager) {
        return offerMapper.getEditorListWithPaging(pager);
    }


    @Override
    public List<OfferVO> findThumbnailer() {
        return offerMapper.findThumbnailer();
    }

    @Override
    public Long findThumbnailerCount(Pager pager) {
        return offerMapper.findThumbnailerCount(pager);
    }

    @Override
    public List<OfferVO> getThumbnailerListWithPaging(Pager pager) {
        return offerMapper.getThumbnailerListWithPaging(pager);
    }




    @Override
    public List<OfferVO> findSdCharacter() {
        return offerMapper.findSdCharacter();
    }
    @Override
    public Long findSdCharacterCount(Pager pager) {
        return offerMapper.findSdCharacterCount(pager);
    }

    @Override
    public List<OfferVO> getSdCharacterListWithPaging(Pager pager) {
        return offerMapper.getSdCharacterListWithPaging(pager);
    }



    @Override
    public List<OfferVO> findVirtual() {
        return offerMapper.findVirtual();
    }

    @Override
    public Long findVirtualCount(Pager pager) {
        return offerMapper.findVirtualCount(pager);
    }

    @Override
    public List<OfferVO> getVirtualListWithPaging(Pager pager) {
        return offerMapper.getVirtualListWithPaging(pager);
    }





    @Override
    public List<OfferVO> findCamaraMan() {
        return offerMapper.findCamaraMan();
    }

    @Override
    public Long findCamaraManCount(Pager pager) {
        return offerMapper.findCamaraManCount(pager);
    }

    @Override
    public List<OfferVO> getCamaraManListWithPaging(Pager pager) {
        return offerMapper.getCamaraManListWithPaging(pager);
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

    @Override
    public void updateOffer(OfferVO offerVO) {
        offerMapper.updateOffer(offerVO);
    }

    @Override
    public void deleteOffer(Long offer_no) {
        offerMapper.deleteOffer(offer_no);
    }


}

package com.project.service;

import com.project.domain.BoardVO;
import com.project.domain.MemberVO;
import com.project.domain.OfferVO;
import com.project.dto.Pager;
import com.project.entity.OfferEntity;
import com.project.repository.JPAOfferMapper;
import com.project.repository.OfferMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class OfferServiceImpl implements OfferService {
    private final OfferMapper offerMapper;
    private  final JPAOfferMapper jpaOfferMapper;
    @Override
    public List<OfferEntity> findEditer() {
        return jpaOfferMapper.findEditer();
    }

    @Override
    public Long findEditerCount(Pager pager) {
        return jpaOfferMapper.findEditerCount(pager);
    }

    @Override
    public List<OfferEntity> getEditorListWithPaging(Pager pager) {
        return jpaOfferMapper.getEditorListWithPaging(pager);
    }


    @Override
    public List<OfferEntity> findThumbnailer() {
        return jpaOfferMapper.findThumbnailer();
    }

    @Override
    public Long findThumbnailerCount(Pager pager) {
        return jpaOfferMapper.findThumbnailerCount(pager);
    }

    @Override
    public List<OfferEntity> getThumbnailerListWithPaging(Pager pager) {
        return jpaOfferMapper.getThumbnailerListWithPaging(pager);
    }

    @Override
    public List<OfferEntity> findSdCharacter() {
        return jpaOfferMapper.findSdCharacter();
    }
    @Override
    public Long findSdCharacterCount(Pager pager) {
        return jpaOfferMapper.findSdCharacterCount(pager);
    }

    @Override
    public List<OfferEntity> getSdCharacterListWithPaging(Pager pager) {
        return jpaOfferMapper.getSdCharacterListWithPaging(pager);
    }

    @Override
    public List<OfferEntity> findVirtual() {
        return jpaOfferMapper.findVirtual();
    }

    @Override
    public Long findVirtualCount(Pager pager) {
        return jpaOfferMapper.findVirtualCount(pager);
    }

    @Override
    public List<OfferEntity> getVirtualListWithPaging(Pager pager) {
        return jpaOfferMapper.getVirtualListWithPaging(pager);
    }



    @Override
    public List<OfferEntity> findCamaraMan() {
        return jpaOfferMapper.findCamaraMan();
    }

    @Override
    public Long findCamaraManCount(Pager pager) {
        return jpaOfferMapper.findCamaraManCount(pager);
    }

    @Override
    public List<OfferEntity> getCamaraManListWithPaging(Pager pager) {
        return jpaOfferMapper.getCamaraManListWithPaging(pager);
    }


    @Override
    public OfferEntity getOffer(Long offer_no) {
        OfferEntity offerEntity = jpaOfferMapper.getOffer(offer_no);
        return offerEntity;
    }


    @Override
    public void addOfferForm(OfferEntity offerEntity) {
        jpaOfferMapper.save(offerEntity);
    }
    @Transactional
    @Override
    public void updateOffer(OfferEntity offerEntity) {
        jpaOfferMapper.updateOffer(offerEntity);
    }


    @Transactional
    @Override
    public void deleteOffer(Long offer_no) {
        jpaOfferMapper.deleteOffer(offer_no);
    }


}

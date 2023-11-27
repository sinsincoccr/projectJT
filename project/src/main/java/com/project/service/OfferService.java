package com.project.service;


import com.project.domain.BoardVO;
import com.project.domain.OfferVO;
import com.project.dto.Pager;
import com.project.entity.OfferEntity;

import java.util.List;

public interface OfferService {


    List<OfferEntity> findEditer();
    Long findEditerCount(Pager pager);
    List<OfferEntity> getEditorListWithPaging(Pager pager);

    List<OfferEntity> findThumbnailer();
    Long findThumbnailerCount(Pager pager);
    List<OfferEntity> getThumbnailerListWithPaging(Pager pager);

    List<OfferEntity> findSdCharacter();
    Long findSdCharacterCount(Pager pager);
    List<OfferEntity> getSdCharacterListWithPaging(Pager pager);

    List<OfferEntity> findVirtual();
    Long findVirtualCount(Pager pager);
    List<OfferEntity> getVirtualListWithPaging(Pager pager);

    List<OfferEntity> findCamaraMan();
    Long findCamaraManCount(Pager pager);
    List<OfferEntity> getCamaraManListWithPaging(Pager pager);

    public OfferEntity getOffer(Long offer_no);

    void addOfferForm(OfferEntity offerEntity);
    void updateOffer(OfferEntity offerEntity);
    void deleteOffer(Long offer_no);

}

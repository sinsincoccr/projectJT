package com.project.repository;


import com.project.domain.BoardVO;
import com.project.domain.MemberVO;
import com.project.domain.OfferVO;
import com.project.dto.Pager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OfferMapper {


    List<OfferVO> findEditer();
    Long findEditerCount(Pager pager);
    List<OfferVO> getEditorListWithPaging(Pager pager);



    List<OfferVO> findThumbnailer();
    Long findThumbnailerCount(Pager pager);
    List<OfferVO> getThumbnailerListWithPaging(Pager pager);



    List<OfferVO> findSdCharacter();
    Long findSdCharacterCount(Pager pager);
    List<OfferVO> getSdCharacterListWithPaging(Pager pager);



    List<OfferVO> findVirtual();
    Long findVirtualCount(Pager pager);
    List<OfferVO> getVirtualListWithPaging(Pager pager);



    List<OfferVO> findCamaraMan();
    Long findCamaraManCount(Pager pager);
    List<OfferVO> getCamaraManListWithPaging(Pager pager);



    public OfferVO getOffer(Long offer_no);


    // 글 저장
    void addOfferForm(OfferVO offerVO);

    void updateOffer(OfferVO offerVO);

    void deleteOffer(Long offer_no);




}

package com.project.repository;


import com.project.domain.OfferVO;
import com.project.domain.SeekerVO;
import com.project.domain.StoreProductVO;
import com.project.dto.Pager;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {

    Long findPremierProStoreCount(Pager pager);
    List<StoreProductVO> getPremierProStoreListWithPaging(Pager pager);



    Long findFinalCutStoreCount(Pager pager);
    List<StoreProductVO> getFinalCutStoreListWithPaging(Pager pager);



    Long findImageStoreCount(Pager pager);
    List<StoreProductVO> getImageStoreListWithPaging(Pager pager);




    List<StoreProductVO> findPowerBannerStore();

    public StoreProductVO getProduct(Long product_no);

    // 글 저장
    void addProductForm(StoreProductVO storeProductVO);

    void updateStore(StoreProductVO storeProductVO);

    void deleteProduct(Long product_no);



}

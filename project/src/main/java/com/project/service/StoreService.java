package com.project.service;


import com.project.domain.OfferVO;
import com.project.domain.SeekerVO;
import com.project.domain.StoreProductVO;
import com.project.dto.Pager;

import java.io.IOException;
import java.util.List;

public interface StoreService {

    // 레스토랑 정보 가져오기
    Long findPremierProStoreCount(Pager pager);
    List<StoreProductVO> getPremierProStoreListWithPaging(Pager pager);



    Long findFinalCutStoreCount(Pager pager);
    List<StoreProductVO> getFinalCutStoreListWithPaging(Pager pager);



    Long findImageStoreCount(Pager pager);
    List<StoreProductVO> getImageStoreListWithPaging(Pager pager);



    List<StoreProductVO> findPowerBannerStore();




    public StoreProductVO getProduct(Long product_no);

    // 글 등록 처리
    void addProductForm(StoreProductVO storeProductVO)throws IOException;

    void updateStore(StoreProductVO storeProductVO)throws IOException;

    void deleteProduct(Long product_no);

    ;
}

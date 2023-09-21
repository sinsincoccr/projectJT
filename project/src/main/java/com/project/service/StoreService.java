package com.project.service;


import com.project.domain.StoreProductVO;

import java.io.IOException;
import java.util.List;

public interface StoreService {

    // 레스토랑 정보 가져오기
    List<StoreProductVO> findPremierProStore();

    List<StoreProductVO> findFinalCutStore();

    List<StoreProductVO> findImageStore();

    List<StoreProductVO> findPowerBannerStore();

    public StoreProductVO getProduct(Long product_no);

    // 글 등록 처리
    void addProductForm(StoreProductVO storeProductVO)throws IOException;

}

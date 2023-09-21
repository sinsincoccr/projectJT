package com.project.repository;


import com.project.domain.SeekerVO;
import com.project.domain.StoreProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {

    List<StoreProductVO> findPremierProStore();

    List<StoreProductVO> findFinalCutStore();

    List<StoreProductVO> findImageStore();

    List<StoreProductVO> findPowerBannerStore();

    public StoreProductVO getProduct(Long product_no);

    // 글 저장
    void addProductForm(StoreProductVO storeProductVO);

}

package com.project.service;


import com.project.domain.FileVO;
import com.project.domain.StoreProductVO;
import com.project.repository.StoreMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class StoreServiceImpl implements StoreService{
    private final FileUpload fileUpload;
    private final StoreMapper storeMapper;

    @Override
    public List<StoreProductVO> findPremierProStore() {
        return storeMapper.findPremierProStore();
    }

    @Override
    public List<StoreProductVO> findFinalCutStore() {
        return storeMapper.findFinalCutStore();
    }

    @Override
    public List<StoreProductVO> findImageStore() {
        return storeMapper.findImageStore();
    }

    @Override
    public List<StoreProductVO> findPowerBannerStore() {
        return storeMapper.findPowerBannerStore();
    }


    @Override
    public StoreProductVO getProduct(Long product_no) {
        StoreProductVO storeProductVO = storeMapper.getProduct(product_no);
        return storeProductVO;
    }

    @Override
    public void addProductForm(StoreProductVO storeProductVO) throws IOException {
        //FileVO fileInfo = fileUpload.saveFile(storeProductVO.getProduct_img());
        //storeProductVO.setProduct_img(fileInfo.getFile_name());
        String savedFileName = fileUpload.saveFile(storeProductVO.getProduct_file());
        storeProductVO.setProduct_img(savedFileName);
        storeProductVO.setProduct_status(1); // 판매중
        storeMapper.addProductForm(storeProductVO);
    }
}

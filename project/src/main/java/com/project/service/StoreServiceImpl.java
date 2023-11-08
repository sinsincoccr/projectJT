package com.project.service;


import com.project.domain.FileVO;
import com.project.domain.OfferVO;
import com.project.domain.SeekerVO;
import com.project.domain.StoreProductVO;
import com.project.dto.Pager;
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
    public Long findPremierProStoreCount(Pager pager) {
        return storeMapper.findPremierProStoreCount(pager);
    }
    @Override
    public List<StoreProductVO> getPremierProStoreListWithPaging(Pager pager) {
        return storeMapper.getPremierProStoreListWithPaging(pager);
    }


    @Override
    public Long findFinalCutStoreCount(Pager pager) {
        return storeMapper.findFinalCutStoreCount(pager);
    }
    @Override
    public List<StoreProductVO> getFinalCutStoreListWithPaging(Pager pager) {
        return storeMapper.getFinalCutStoreListWithPaging(pager);
    }


    @Override
    public Long findImageStoreCount(Pager pager) {
        return storeMapper.findImageStoreCount(pager);
    }
    @Override
    public List<StoreProductVO> getImageStoreListWithPaging(Pager pager) {
        return storeMapper.getImageStoreListWithPaging(pager);
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

    @Override
    public void updateStore(StoreProductVO storeProductVO) throws IOException {
        String savedFileName = fileUpload.saveFile(storeProductVO.getProduct_file());
        storeProductVO.setProduct_img(savedFileName);
        storeProductVO.setProduct_status(1); // 판매중
        storeMapper.updateStore(storeProductVO);

    }

    @Override
    public void deleteProduct(Long product_no) {
        storeMapper.deleteProduct(product_no);
    }


}

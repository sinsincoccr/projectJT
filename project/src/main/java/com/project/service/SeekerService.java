package com.project.service;

import com.project.domain.OfferVO;
import com.project.domain.SeekerVO;

import java.util.List;

public interface SeekerService {

    List<SeekerVO> findEditerSeeker();

    List<SeekerVO> findThumbnailerSeeker();

    List<SeekerVO> findSdCharacterSeeker();

    List<SeekerVO> findVirtualSeeker();

    List<SeekerVO> findCamaraManSeeker();

    public SeekerVO getSeeker(Long seeker_no);


    // 글 등록 처리
    void addSeekerForm(SeekerVO seekerVO);


}

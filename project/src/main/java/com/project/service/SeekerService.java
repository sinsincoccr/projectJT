package com.project.service;

import com.project.domain.OfferVO;
import com.project.domain.SeekerVO;
import com.project.dto.Pager;

import java.util.List;

public interface SeekerService {

    List<SeekerVO> findEditerSeeker();

    Long findEditerSeekerCount(Pager pager);

    List<SeekerVO> getEditerSeekerListWithPaging(Pager pager);




    // List<SeekerVO> findThumbnailerSeeker();
    Long findThumbnailerSeekerCount(Pager pager);
    List<SeekerVO> getThumbnailerSeekerListWithPaging(Pager pager);


    //List<SeekerVO> findSdCharacterSeeker();
    Long findSdCharacterSeekerCount(Pager pager);
    List<SeekerVO> getSdCharacterSeekerListWithPaging(Pager pager);

    //List<SeekerVO> findVirtualSeeker();
    Long findVirtualSeekerCount(Pager pager);
    List<SeekerVO> getVirtualSeekerListWithPaging(Pager pager);

    //List<SeekerVO> findCamaraManSeeker();
    Long findCamaraManSeekerCount(Pager pager);
    List<SeekerVO> getCamaraManSeekerListWithPaging(Pager pager);



    public SeekerVO getSeeker(Long seeker_no);


    // 글 등록 처리
    void addSeekerForm(SeekerVO seekerVO);

    void updateSeeker(SeekerVO seekerVO);

    void deleteSeeker(Long seeker_no);

}

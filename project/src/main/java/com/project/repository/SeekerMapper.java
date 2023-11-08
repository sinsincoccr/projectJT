package com.project.repository;


import com.project.domain.SeekerVO;
import com.project.dto.Pager;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SeekerMapper {


    List<SeekerVO> findEditerSeeker();
    Long findEditerSeekerCount(Pager pager);
    List<SeekerVO> getEditerSeekerListWithPaging(Pager pager);


    List<SeekerVO> findThumbnailerSeeker();
    Long findThumbnailerSeekerCount(Pager pager);
    List<SeekerVO> getThumbnailerSeekerListWithPaging(Pager pager);

    List<SeekerVO> findSdCharacterSeeker();
    Long findSdCharacterSeekerCount(Pager pager);
    List<SeekerVO> getSdCharacterSeekerListWithPaging(Pager pager);

    List<SeekerVO> findVirtualSeeker();
    Long findVirtualSeekerCount(Pager pager);
    List<SeekerVO> getVirtualSeekerListWithPaging(Pager pager);

    List<SeekerVO> findCamaraManSeeker();
    Long findCamaraManSeekerCount(Pager pager);
    List<SeekerVO> getCamaraManSeekerListWithPaging(Pager pager);

    public SeekerVO getSeeker(Long seeker_no);


    // 글 저장
    void addSeekerForm(SeekerVO seekerVO);

    void updateSeeker(SeekerVO seekerVO);

    void deleteSeeker(Long seeker_no);

}

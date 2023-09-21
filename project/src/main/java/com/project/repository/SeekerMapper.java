package com.project.repository;


import com.project.domain.SeekerVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SeekerMapper {


    List<SeekerVO> findEditerSeeker();

    List<SeekerVO> findThumbnailerSeeker();

    List<SeekerVO> findSdCharacterSeeker();

    List<SeekerVO> findVirtualSeeker();

    List<SeekerVO> findCamaraManSeeker();

    public SeekerVO getSeeker(Long seeker_no);


    // 글 저장
    void addSeekerForm(SeekerVO seekerVO);




}

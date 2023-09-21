package com.project.service;

import com.project.domain.OfferVO;
import com.project.domain.SeekerVO;
import com.project.repository.OfferMapper;
import com.project.repository.SeekerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class SeekerServiceImpl implements SeekerService{

    private final SeekerMapper seekerMapper;

    @Override
    public List<SeekerVO> findEditerSeeker() {
        return seekerMapper.findEditerSeeker();
    }

    @Override
    public List<SeekerVO> findThumbnailerSeeker() {
        return seekerMapper.findThumbnailerSeeker();
    }

    @Override
    public List<SeekerVO> findSdCharacterSeeker() {
        return seekerMapper.findSdCharacterSeeker();
    }

    @Override
    public List<SeekerVO> findVirtualSeeker() { return seekerMapper.findVirtualSeeker();
    }

    @Override
    public List<SeekerVO> findCamaraManSeeker() {
        return seekerMapper.findCamaraManSeeker();
    }

    @Override
    public SeekerVO getSeeker(Long seeker_no) {
        SeekerVO seekerVO = seekerMapper.getSeeker(seeker_no);
        return seekerVO;
    }


    @Override
    public void addSeekerForm(SeekerVO seekerVO) {
        seekerMapper.addSeekerForm(seekerVO);
    }




}

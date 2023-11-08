package com.project.service;

import com.project.domain.OfferVO;
import com.project.domain.SeekerVO;
import com.project.dto.Pager;
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
    public Long findEditerSeekerCount(Pager pager) {
        return seekerMapper.findEditerSeekerCount(pager);
    }
    @Override
    public List<SeekerVO> getEditerSeekerListWithPaging(Pager pager) {
        return seekerMapper.getEditerSeekerListWithPaging(pager);
    }


    @Override
    public Long findThumbnailerSeekerCount(Pager pager) {
        return seekerMapper.findThumbnailerSeekerCount(pager);
    }
    @Override
    public List<SeekerVO> getThumbnailerSeekerListWithPaging(Pager pager) {
        return seekerMapper.getThumbnailerSeekerListWithPaging(pager);
    }


    @Override
    public Long findSdCharacterSeekerCount(Pager pager) {
        return seekerMapper.findSdCharacterSeekerCount(pager);
    }
    @Override
    public List<SeekerVO> getSdCharacterSeekerListWithPaging(Pager pager) {
        return seekerMapper.getSdCharacterSeekerListWithPaging(pager);
    }


    @Override
    public Long findVirtualSeekerCount(Pager pager) {
        return seekerMapper.findVirtualSeekerCount(pager);
    }

    @Override
    public List<SeekerVO> getVirtualSeekerListWithPaging(Pager pager) {
        return seekerMapper.getVirtualSeekerListWithPaging(pager);
    }



    @Override
    public Long findCamaraManSeekerCount(Pager pager) {
        return seekerMapper.findCamaraManSeekerCount(pager);
    }

    @Override
    public List<SeekerVO> getCamaraManSeekerListWithPaging(Pager pager) {
        return seekerMapper.getCamaraManSeekerListWithPaging(pager);
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

    @Override
    public void updateSeeker(SeekerVO seekerVO) {
        seekerMapper.updateSeeker(seekerVO);
    }

    @Override
    public void deleteSeeker(Long seeker_no) {
        seekerMapper.deleteSeeker(seeker_no);
    }
}

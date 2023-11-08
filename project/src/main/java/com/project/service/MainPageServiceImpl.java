package com.project.service;

import com.project.domain.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MainPageServiceImpl implements MainPageService{
    @Override
    public MemberVO editer(MemberVO member){
        return member;
    }

    @Override
    public MemberVO thumbnailer(MemberVO member) {
        return member;
    }

    @Override
    public MemberVO sdCharacter(MemberVO member) {
        return member;
    }

    @Override
    public MemberVO virtual(MemberVO member) {
        return member;
    }

    @Override
    public MemberVO camaraMan(MemberVO member) {
        return member;
    }
}

package com.project.service;

import com.project.domain.MemberVO;
import com.project.domain.OfferVO;
import com.project.repository.MemberMapper;
import com.project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    //회원가입
    @Override
    public MemberVO createId(MemberVO member) {
        return memberRepository.createId(member);
    }



    @Override
    public MemberVO login(MemberVO member) {
        MemberVO findMember = memberRepository.findById(member.getUser_id());
        log.info("== member : {}", member);
        log.info("== findMember : {}", findMember);
        if(findMember != null){
            if(findMember.getUser_pw().equals(member.getUser_pw())){
                return findMember;
            }
        }
        return null; // findMember가 없거나(username X) , 비번이 틀리면 null 리턴
    }

    @Override
    public MemberVO getMember(Long user_no) {
        MemberVO memberVO = memberMapper.getMember(user_no);
        return memberVO;
    }

}

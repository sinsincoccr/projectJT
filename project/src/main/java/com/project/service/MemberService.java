package com.project.service;


import com.project.domain.MemberVO;
import com.project.domain.OfferVO;


import java.util.List;
import java.util.Optional;

public interface MemberService{

    //회원 가입
    MemberVO createId(MemberVO member);

    MemberVO login(MemberVO member);

    public MemberVO getMember(Long user_no);

    public int idCheck(String id);

    void modifyId(MemberVO member);

}

package com.project.repository;

import com.project.domain.MemberVO;
import com.project.domain.OfferVO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {


    int createId(MemberVO member);

    // username 으로 회원 한명 정보 가져오기
    MemberVO findById(String user_id);

    public MemberVO getMember(Long user_no);



}

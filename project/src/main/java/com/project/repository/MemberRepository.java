package com.project.repository;

import com.project.domain.MemberVO;

public interface MemberRepository {
    // 회원 가입
    MemberVO createId(MemberVO member);

    // id로 회원 한명 정보 가져오기
    MemberVO findById(String user_id);
}


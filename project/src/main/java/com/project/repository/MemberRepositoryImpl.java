package com.project.repository;

import com.project.domain.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberRepositoryImpl  implements MemberRepository{

    private final MemberMapper memberMapper;

    @Override
    public MemberVO createId(MemberVO member) {
        log.info("repository member before : {}", member);
        memberMapper.createId(member);
        log.info("repository member after : {}", member);
        return member;
    }

    @Override
    public MemberVO findById(String user_id) {
        return memberMapper.findById(user_id);
    }
}

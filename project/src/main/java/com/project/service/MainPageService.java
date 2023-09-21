package com.project.service;

import com.project.domain.MemberVO;

public interface MainPageService {

    //메인페이지에서 음식점 주제로 이동
    MemberVO editer(MemberVO member);

    MemberVO thumbnailer(MemberVO member);

    MemberVO sdCharacter(MemberVO member);

    MemberVO virtual(MemberVO member);

    MemberVO camaraMan(MemberVO member);


}

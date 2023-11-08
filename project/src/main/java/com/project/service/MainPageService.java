package com.project.service;

import com.project.domain.MemberVO;

public interface MainPageService {
    MemberVO editer(MemberVO member);

    MemberVO thumbnailer(MemberVO member);

    MemberVO sdCharacter(MemberVO member);

    MemberVO virtual(MemberVO member);

    MemberVO camaraMan(MemberVO member);


}

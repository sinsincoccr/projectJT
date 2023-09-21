package com.project.repository;

import com.project.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainPageMapper {

    int editer(MemberVO member);

    int thumbnailer(MemberVO member);

    int sdCharacter(MemberVO member);

    int virtual(MemberVO member);

    int camaraMan(MemberVO member);

}

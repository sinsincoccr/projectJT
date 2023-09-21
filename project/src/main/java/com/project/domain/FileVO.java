package com.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

// 파일 하나에 대한 정보를 담는 객체
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileVO {
    private String orgFileName;     // 원본파일이름
    private String file_name;  // uuid 로 서버에 저장할때 만들어진 이름
}

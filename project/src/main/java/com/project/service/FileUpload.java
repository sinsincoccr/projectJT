package com.project.service;


import com.project.domain.FileVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component // 일반 부품 클래스 -> 스프링빈으로 등록
public class FileUpload {
    @Value("${file.dir}") // application.properties 에 저장한 파일 저장 경로 가져오기
    private String fileDir;

    // 이미지 저장
    // 실제 파일 한개 저장 : 이미지도 저장, 첨부파일 저장
    public String saveFile(MultipartFile multipartFile) throws IOException {
        if(multipartFile.isEmpty()){ // 사용자가 파일 업로드 안함 -> 그냥 종료
            return null;
        }
        String orgFileName = multipartFile.getOriginalFilename();
        String file_name = makeFileName(orgFileName);
        multipartFile.transferTo(new File(getFilePath(file_name))); //  실제 파일 저장 명령어
        return file_name;
    }

    // 파일 전체 경로 만들기
    public String getFilePath(String filename) {
        return fileDir + filename;
    }

    // uuid 활용해 저장할 파일이름 생성 -> 리턴
    private String makeFileName(String orgFileName) {
        String ext = extractExt(orgFileName); // 확장자만 추출
        String uuid = UUID.randomUUID().toString();
        return uuid + ext;
    }
    private String extractExt(String orgFileName) { // 확장자명 추출
        int idx = orgFileName.lastIndexOf(".");
        String ext = orgFileName.substring(idx);
        return ext;
    }

}

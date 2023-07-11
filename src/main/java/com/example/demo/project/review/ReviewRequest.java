package com.example.demo.project.review;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ReviewRequest {
    private Long id;
    private String title;
    private String writer;
    private int secretYn;
    private String content;
    private String password;
    private int ord;
    private int deleteYn;
    private List<MultipartFile> files = new ArrayList<>();// 첨부파일 List
    private String originalName;
    private String saveName;
    private String uploadPath;
}

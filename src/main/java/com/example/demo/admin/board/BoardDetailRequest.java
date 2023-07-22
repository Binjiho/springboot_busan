package com.example.demo.admin.board;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BoardDetailRequest {
    private Long id;
    private Long board_id;
    private String title;
    private String writer;
    private List<MultipartFile> files = new ArrayList<>();// 첨부파일 List
    private String originalName;
    private String saveName;
    private String uploadPath;
}

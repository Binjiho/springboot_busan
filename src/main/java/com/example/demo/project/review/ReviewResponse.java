package com.example.demo.project.review;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReviewResponse {
    private Long id;                       // PK
    private String title;                  // 제목
    private String writer;                 // 작성자
    private int secretYn;                  // 비밀글 여부
    private String content;                // 내용
    private String password;               // 비밀번호
    private int ord;                       // 순서
    private String originalName;           // 원본 파일명
    private String saveName;               // 저장 파일명
    private String uploadPath;             // 저장 경로
    private Boolean deleteYn;              // 삭제 여부
    private LocalDateTime createdDate;     // 생성일시
    private LocalDateTime modifiedDate;    // 최종 수정일시
    private LocalDateTime deletedDate;     // 삭제 일시
}

package com.example.demo.admin.board;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardDetailResponse {
    private Long id;                       // PK
    private Long board_id;                 // FK
    private String title;                  // 제목
    private String writer;                 // 작성자
    private String originalName;
    private String saveName;              // 저장 파일명
    private String uploadPath;            // 저장 경로
    private Boolean deleteYn;              // 삭제 여부
    private LocalDateTime createdDate;     // 생성일시
    private LocalDateTime modifiedDate;    // 최종 수정일시
    private LocalDateTime deletedDate;     // 삭제 일시
}

package com.example.demo.admin.notice;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NoticeResponse {
    private Long id;                       // PK
    private String title;                  // 제목
    private String writer;                 // 작성자
    private String content;                // 내용
    private int ord;                       // 순서
    private int deleteYn;                  // 삭제 여부
    private LocalDateTime startDate;       // 시작일시
    private LocalDateTime endDate;         // 마감일시
}

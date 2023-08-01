package com.example.demo.project.file.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileReviewDto {
    private Long id;
    private String title;
    private String writer;
    private String content;
    private String password;
    private Integer secretYn;
    private Integer ord;
    private String originalName;
    private String saveName;
    private String uploadPath;
    private Integer deleteYn;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}

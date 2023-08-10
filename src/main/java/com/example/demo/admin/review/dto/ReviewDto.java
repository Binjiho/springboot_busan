package com.example.demo.admin.review.dto;

import com.example.demo.admin.notice.entity.NoticeEntity;
import com.example.demo.admin.review.entity.ReviewEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReviewDto {
    private Long id;
    private String title;
    private String writer;
    private String content;
    private String password;
    private int secretYn;
    private int ord;
    private int deleteYn;
    private int isFile;
    private List<MultipartFile> files = new ArrayList<>(); // 첨부파일 List
    private int cCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedDate;

    public static ReviewDto toDto(final ReviewEntity reviewEntity){
        return ReviewDto.builder()
                .id(reviewEntity.getId())
                .title(reviewEntity.getTitle())
                .writer(reviewEntity.getWriter())
                .content(reviewEntity.getContent())
                .password(reviewEntity.getPassword())
                .secretYn(reviewEntity.getSecretYn())
                .ord(reviewEntity.getOrd())
                .deleteYn(reviewEntity.getDeleteYn())
                .isFile(reviewEntity.getIsFile())
                .cCode(reviewEntity.getCCode())
                .createdDate(reviewEntity.getCreatedDate())
                .modifiedDate(reviewEntity.getModifiedDate())
                .build();
    }
}

package com.example.demo.admin.review.dto;

import com.example.demo.admin.review.entity.ReviewEntity;
import com.example.demo.base.file.entity.FileEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public interface ReviewWithFileDto {
//    ReviewEntity getReviewEntity();
//    FileEntity getFileEntity();
    Long getId();
    String getTitle();
    String getWriter();
    String getContent();
    String getPassword();
    int getSecretYn();
    int getOrd();
    int getDeleteYn();
    int getIsFile();

    int getcCode();

    String getSaveName();
    String getUploadPath();
}

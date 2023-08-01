package com.example.demo.project.file.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileDto {
    private Long id;
    private String originalName;
    private String saveName;
    private String uploadPath;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}

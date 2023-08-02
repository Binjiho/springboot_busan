package com.example.demo.base.file.dto;

import com.example.demo.admin.notice.dto.NoticeDto;
import com.example.demo.admin.notice.entity.NoticeEntity;
import com.example.demo.base.file.entity.FileEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileDto {
    private Long id;
    private Long boardId;
    private String originalName;
    private String saveName;
    private String uploadPath;
    private int cCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedDate;

    public void setBoard_id(Long boardId) {
        this.boardId = boardId;
    }

    public static FileDto toDto(final FileEntity fileEntity){
        return FileDto.builder()
                .id(fileEntity.getId())
                .boardId(fileEntity.getBoardId())
                .originalName(fileEntity.getOriginalName())
                .saveName(fileEntity.getSaveName())
                .uploadPath(fileEntity.getUploadPath())
                .cCode(fileEntity.getCCode())
                .createdDate(fileEntity.getCreatedDate())
                .modifiedDate(fileEntity.getModifiedDate())
                .build();
    }
}

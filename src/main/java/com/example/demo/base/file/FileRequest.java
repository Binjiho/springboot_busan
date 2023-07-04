package com.example.demo.base.file;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FileRequest {
    private Long id;
    private Long board_id;
    private String originalName;
    private String saveName;
    private String uploadPath;
    private Long size;

    @Builder
    public FileRequest(String originalName, String saveName, String uploadPath, long size) {
        this.originalName = originalName;
        this.saveName = saveName;
        this.uploadPath = uploadPath;
        this.size = size;
    }

    public void setBoard_id(Long board_id) {
        this.board_id = board_id;
    }
}

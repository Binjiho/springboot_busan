package com.example.demo.admin.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequest {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private Boolean noticeYn;
}

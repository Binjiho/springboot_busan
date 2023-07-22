package com.example.demo.comment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentRequest {
    private Long id;
    private Long boardId;
    private String content;
    private String writer;
}

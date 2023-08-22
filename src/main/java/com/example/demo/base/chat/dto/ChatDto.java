package com.example.demo.base.chat.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ChatDto {
    private Long id;
    private String search;
    private String answer;
}

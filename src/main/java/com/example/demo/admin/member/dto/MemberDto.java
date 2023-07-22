package com.example.demo.admin.member.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class MemberDto {
    private Long id;
    private String userId;
    private String userPw;
    private String name;
    private String htel;
    private int fromSocial;
    private int deleteYn;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}

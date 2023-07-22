package com.example.demo.admin.member;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class MemberResponse {

    private Long id;                        // 회원 번호 (PK)
    private String userId;                  // 로그인 ID
    private String userPw;                  // 비밀번호
    private String name;                    // 이름
    private String email;                   // 성별
    private String htel;                    // 전화번호
    private String address;                 // 주소
    private int grade;                      // 권한번호
    private Boolean deleteYn;               // 삭제 여부
    private LocalDateTime createdDate;      // 생성일시
    private LocalDateTime modifiedDate;     // 최종 수정일시


    public void clearPassword() {
        this.userPw = "";
    }

}
package com.example.demo.admin.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberRequest {

    private Long id;                // 회원 번호 (PK)
    private String userId;          // 로그인 ID
    private String userPw;          // 비밀번호
    private String name;            // 이름
    private String email;           // 성별
    private String htel;            // 전화번호
    private String address;         // 주소
    private int grade;              // 권한번호
    private LocalDate created_date; // 생성일자

    public void encodingPassword(PasswordEncoder passwordEncoder) {
        if (StringUtils.isEmpty(userPw)) {
            return;
        }
        userPw = passwordEncoder.encode(userPw);
    }

}
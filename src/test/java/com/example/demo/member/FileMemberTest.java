package com.example.demo.member;

import com.example.demo.project.file.constrant.Role;
import com.example.demo.project.file.dto.FileMemberDto;
import com.example.demo.project.file.repository.FileMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FileMemberTest {
    @Autowired
    FileMemberRepository fileMemberRepository;

    @Test
    void insert(){
        FileMemberDto fileMemberDto = new FileMemberDto();
        fileMemberDto = FileMemberDto.builder()
                .role(Role.ROLE_MEMBER)
                .email("fileMember@gmail.com")
                .password("1234")
                .build();

    }
}

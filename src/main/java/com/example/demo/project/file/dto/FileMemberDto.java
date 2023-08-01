package com.example.demo.project.file.dto;

import com.example.demo.project.file.constrant.Role;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileMemberDto {
    private Long id;
    private String email;
    private String password;
    private Role role;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}

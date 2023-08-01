package com.example.demo.project.file.entity;

import com.example.demo.project.file.constrant.Role;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "file_member_0801")
public class FileMemberEntity extends BaseEntity {
    @Id // 기본키 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto_increment
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_email",nullable = false,length = 255)
    private String email;

    @Column(nullable = false,length = 100)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // 1: N BoardEntity
    @OneToMany(mappedBy = "fileMemberEntity",fetch = FetchType.LAZY,
            cascade = CascadeType.REFRESH)
    private List<FileReviewEntity> fileReviewEntityList=new ArrayList<>();
}

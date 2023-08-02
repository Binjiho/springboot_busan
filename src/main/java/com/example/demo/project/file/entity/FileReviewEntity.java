package com.example.demo.project.file.entity;

import com.example.demo.base.file.entity.FileEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
@Entity
@Table(name = "file_review_0801")
public class FileReviewEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @Column(name= "title", length = 50, nullable = false)
    private String title;

    @Column(name="writer", length = 50, nullable = false)
    private String writer;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(name="secret_yn", columnDefinition = "tinyint(1)", nullable = false)
    @ColumnDefault("0")
    private Integer secretYn;

    @Column(columnDefinition = "tinyint(1)")
    @ColumnDefault("0")
    private Integer ord;

    @Column(name = "delete_yn" , columnDefinition = "tinyint(1)")
    @ColumnDefault("0")
    private Integer deleteYn;

    @Column(nullable = false,length = 1)
    private int isFile;

//    //N:1 FileMemberEntity
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")  // 참조테이블(MemberEntity,기본키)
//    private FileMemberEntity fileMemberEntity;
//
//    @OneToMany(mappedBy = "fileReviewEntity",fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//    private List<FileEntity> fileEntityList=new ArrayList<>();
}

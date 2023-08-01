package com.example.demo.project.file.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
@Entity
@Table(name = "files")
public class FileEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="original_name", nullable = false)
    private String originalName;

    @Column(name="save_name", nullable = false)
    private String saveName;

    @Column(name="upload_path", nullable = false)
    private String uploadPath;

    //N:1 FileReviewEntity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="review_id")
    private FileReviewEntity fileReviewEntity;
}

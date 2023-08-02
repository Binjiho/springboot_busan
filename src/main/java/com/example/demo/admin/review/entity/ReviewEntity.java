package com.example.demo.admin.review.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name="c_code", nullable = false)
    private int cCode;

    @CreationTimestamp
    @Column(name="created_date", updatable=false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name="modified_date", insertable=false)
    private LocalDateTime modifiedDate;
}

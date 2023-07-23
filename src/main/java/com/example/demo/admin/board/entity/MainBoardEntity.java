package com.example.demo.admin.board.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
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
@Table(name = "main_board")
public class MainBoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title", length = 100, nullable = false)
    private String userPw;

    @Column(name="writer", length = 20, nullable = false)
    private String name;

    @Column(name = "delete_yn")
    @ColumnDefault("0")
    private Integer deleteYn;

    @CreatedDate
    @Column(name="created_date", updatable=false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name="modified_date", insertable=false)
    private LocalDateTime modifiedDate;
}

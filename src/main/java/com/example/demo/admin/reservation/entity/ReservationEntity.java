package com.example.demo.admin.reservation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "reservation_schedule")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "title", length = 50, nullable = false)
    private String title;

    @Column(columnDefinition = "tinyint(1)")
    @ColumnDefault("0")
    private int status;

    @Column(columnDefinition = "tinyint(1)")
    @ColumnDefault("0")
    private Integer ord;

    private LocalDate start;
    private LocalDate end;
}

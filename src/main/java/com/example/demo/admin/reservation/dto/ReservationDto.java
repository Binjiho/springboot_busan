package com.example.demo.admin.reservation.dto;

import com.example.demo.admin.reservation.entity.ReservationEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReservationDto {
    private Long id;                                    // PK
    private String title;                               // 제목
    private int status;                                 // Room 상태값
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate start;                            // 시작일자
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;                              // 마감일자
    private int ord;                                    // 순번
    private String rooms;                               // rooms 상태값

    public static ReservationDto toDto(final ReservationEntity reservationEntity){
        return ReservationDto
                .builder()
                .id(reservationEntity.getId())
                .title(reservationEntity.getTitle())
                .status(reservationEntity.getStatus())
                .start(reservationEntity.getStart())
                .end(reservationEntity.getEnd())
                .build();
    }
}

package com.example.demo.admin.reservation;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ReservationDto {
    private Long id;                       // PK
    private String title;                  // 제목
    private int status;                    // 키즈핑크 상태값
    private LocalDate startDate;           // 시작일자
    private LocalDate endDate;             // 마감일자
    private int ord;                       // 순번

    @Builder
    public ReservationDto(String title, int status, LocalDate startDate, int ord) {
        this.title = title;
        this.status = status;
        this.startDate = startDate;
        this.ord = ord;
    }
}

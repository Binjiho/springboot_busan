package com.example.demo.admin.reservation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Data;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationResponse {
    private Long id;                       // PK
    private String title;                  // 제목
    private int status;                    // 상태값
    private Boolean payedYn;               // 결제 여부
    private LocalDate startDate;           // 시작일자
    private LocalDate endDate;             // 마감일자
    private int ord;                       // 순번
}

package com.example.demo.admin.reservation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import java.time.LocalDateTime;


@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationResponse {
    private Long id;                       // PK
    private String title;                  // 제목
    private int status;                    // 상태값
    private Boolean deleteYn;              // 삭제 여부
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime startDate;       // 시작일자
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime endDate;         // 마감일자
    private int ord;                       // 순번
}

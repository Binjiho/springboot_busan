package com.example.demo.admin.reservation;

import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface ReservationMapper {

    /**
     * 스케쥴 리스트 조회
     * @return 스케쥴 리스트
     */
    List<ReservationResponse> findAll();

    /**
     * 특정 스케쥴 리스트 조회
     * @return 스케쥴 리스트
     */
    List<ReservationResponse> find(ReservationRequest param);

    /**
     * 스케쥴 저장
     * @param params - 게시글 정보
     */
    void save(ReservationDto params);

    /**
     * 스케쥴 갱신
     * @param params
     */
    void update(ReservationRequest params);


}

package com.example.demo.admin.reservation;

import org.apache.ibatis.annotations.Mapper;

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
     * 게시글 저장
     * @param params - 게시글 정보
     */
//    void save(BoardRequest params);

    /**
     * 게시글 삭제
     * @param id - PK
     */
//    void deleteById(Long id);


}

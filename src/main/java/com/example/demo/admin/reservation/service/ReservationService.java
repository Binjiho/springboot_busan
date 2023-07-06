package com.example.demo.admin.reservation.service;

import com.example.demo.admin.board.BoardRequest;
import com.example.demo.admin.reservation.ReservationDto;
import com.example.demo.admin.reservation.ReservationMapper;
import com.example.demo.admin.reservation.ReservationRequest;
import com.example.demo.admin.reservation.ReservationResponse;
import com.example.demo.base.file.FileRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationMapper reservationMapper;

    /**
     * 스케쥴 리스트 조회
     *
     * @return list & map
     */
    public List<ReservationResponse> findAllPost() {
        List<ReservationResponse> list = reservationMapper.findAll();
        return list;
    }

    /**
     * 특정일자 스케쥴 리스트 조회
     *
     * @return list & map
     */
    public List<ReservationResponse> findPost(final ReservationRequest param) {
        List<ReservationResponse> list = reservationMapper.find(param);
        return list;
    }

    /**
     * 스케쥴 저장
     * @param params
     * @return Generated PK
     */
    @Transactional
    public void savePost(final List<ReservationDto> params) {
        for (ReservationDto reservationDto : params) {
            reservationMapper.save(reservationDto);
        }
    }

    /**
     * 스케쥴 갱신
     * @param params
     * @return PK
     */
    @Transactional
    public Long updatePost(final ReservationRequest params) {
        reservationMapper.update(params);
        return params.getId();
    }


}

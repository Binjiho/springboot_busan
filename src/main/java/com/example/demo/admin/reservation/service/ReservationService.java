package com.example.demo.admin.reservation.service;

import com.example.demo.admin.reservation.ReservationMapper;
import com.example.demo.admin.reservation.ReservationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
     * 스케쥴 저장
     * @param params - 게시글 정보
     * @return Generated PK
     */
//    @Transactional
//    public Long savePost(final BoardRequest params) {
//        boardMapper.save(params);
//        return params.getId();
//    }

    /**
     * 스케쥴 삭제
     * @param id - PK
     * @return PK
     */
//    public Long deletePost(final Long id) {
//        boardMapper.deleteById(id);
//        return id;
//    }


}

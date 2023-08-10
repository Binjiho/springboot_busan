package com.example.demo.admin.reservation.service;

import com.example.demo.admin.reservation.dto.ReservationDto;
import com.example.demo.admin.reservation.entity.ReservationEntity;
import com.example.demo.admin.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ReservationService {
//    private final ReservationMapper reservationMapper;
    private final ReservationRepository reservationRepository;

    /**
     * 스케쥴 리스트 조회
     *
     * @return list & map
     */
    public List<ReservationDto> findAll() {
        List<ReservationEntity> list = reservationRepository.findAll();
        List<ReservationDto> result = list.stream().map(ReservationDto::toDto).collect(Collectors.toList());
        return result;
    }

    /**
     * 특정일자 스케쥴 리스트 조회
     * @param reservationDto
     * @return list & map
     */
    public List<ReservationDto> findByStartDate(final ReservationDto reservationDto) {
        LocalDate start = reservationDto.getStart();
        LocalDate end = start.plusDays(1);

        List<ReservationEntity> list = reservationRepository.findAllByStartBetween(start,end);
        List<ReservationDto> result = list.stream().map(ReservationDto::toDto).collect(Collectors.toList());
        return result;
    }

    /**
     * 스케쥴 갱신
     * @param reservationDto
     * @return PK
     */
    @Transactional
    public Long updatePost(final ReservationDto reservationDto) {
        ReservationEntity reservationEntity = ReservationEntity
                .builder()
                .id(reservationDto.getId())
                .title(reservationDto.getTitle())
                .status(reservationDto.getStatus())
                .start(reservationDto.getStart())
                .end(reservationDto.getEnd())
                .ord(reservationDto.getOrd())
                .build();
        Long reservationId = reservationRepository.save(reservationEntity).getId();
        return reservationId;
    }

    /**
     * 스케쥴 저장
     * @param reservationDto
     * @return Generated PK
     */
    @Transactional
    public void savePost(final ReservationDto reservationDto) {
        ReservationEntity reservationEntity = ReservationEntity
                .builder()
                .title(reservationDto.getTitle())
                .status(reservationDto.getStatus())
                .start(reservationDto.getStart())
                .ord(reservationDto.getOrd())
                .build();
        reservationRepository.save(reservationEntity);
    }


}

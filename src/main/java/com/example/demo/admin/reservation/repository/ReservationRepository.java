package com.example.demo.admin.reservation.repository;

import com.example.demo.admin.reservation.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    public List<ReservationEntity> findAllByStartBetween(LocalDate start, LocalDate end);
}

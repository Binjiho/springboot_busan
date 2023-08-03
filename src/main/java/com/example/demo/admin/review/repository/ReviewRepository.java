package com.example.demo.admin.review.repository;

import com.example.demo.admin.review.dto.ReviewWithFileDto;
import com.example.demo.admin.review.entity.ReviewEntity;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long>, QuerydslPredicateExecutor<ReviewEntity> {

    //연관 관계가 없는 Entity와 외부 조인은 Hibernate 5.1부터 지원
    @Query("SELECT r, f FROM ReviewEntity r LEFT OUTER JOIN FileEntity f ON r.id = f.boardId AND r.cCode = f.cCode")
    List<ReviewWithFileDto> findReviewWithFiles(BooleanBuilder booleanBuilder, Pageable pageable);
}

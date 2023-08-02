package com.example.demo.admin.review.repository;

import com.example.demo.admin.review.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long>, QuerydslPredicateExecutor<ReviewEntity> {
}

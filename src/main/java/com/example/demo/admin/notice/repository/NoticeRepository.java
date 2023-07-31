package com.example.demo.admin.notice.repository;

import com.example.demo.admin.notice.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Long>, QuerydslPredicateExecutor<NoticeEntity> {
}

package com.example.demo.project.file.repository;

import com.example.demo.project.file.entity.FileReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileReviewRepository extends JpaRepository<FileReviewEntity, Long> {
}

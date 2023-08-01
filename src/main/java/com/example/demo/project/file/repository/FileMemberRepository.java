package com.example.demo.project.file.repository;

import com.example.demo.project.file.entity.FileMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileMemberRepository extends JpaRepository<FileMemberEntity, Long> {
}

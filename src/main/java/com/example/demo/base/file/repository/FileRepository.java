package com.example.demo.base.file.repository;

import com.example.demo.base.file.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {
//    List<FileEntity> findBycCode(int cCode);
    List<FileEntity> findBycCodeAndBoardId(int cCode,Long boardId);
}

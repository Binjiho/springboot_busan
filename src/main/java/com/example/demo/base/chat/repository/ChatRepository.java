package com.example.demo.base.chat.repository;

import com.example.demo.base.chat.entity.ChatEntity;
import kr.co.shineware.nlp.komoran.test.KomoranTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity,Long> {
    Optional<ChatEntity> findBySearch(String search);
}

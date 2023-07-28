package com.example.demo.notice;

import com.example.demo.admin.notice.entity.NoticeEntity;
import com.example.demo.admin.notice.repository.NoticeRepository;
import com.example.demo.admin.notice.service.NoticeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@SpringBootTest
public class NoticeServiceTest {
    @Autowired
    NoticeRepository noticeRepository;

    @Test
    void save() {
        for (int i = 1; i <= 100; i++) {
            NoticeEntity noticeEntity = NoticeEntity.builder()
                    .title("test제목"+i)
                    .writer("test작성자"+i)
                    .content("test내용"+i)
                    .deleteYn(0)
                    .startDate(LocalDateTime.now())
                    .endDate(LocalDateTime.now())
                    .ord(0)
                    .build();
            noticeRepository.save(noticeEntity);
        }
    }
}

package com.example.demo.board.post;

import com.example.demo.admin.board.BoardRequest;
import com.example.demo.admin.board.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {
    @Autowired
    BoardService boardService;

    @Test
    void save() {
//        for (int i = 1; i <= 1000; i++) {
//            BoardRequest params = new BoardRequest();
//            params.setTitle(i + "번 게시글 제목");
//            params.setContent(i + "번 게시글 내용");
//            params.setWriter("테스터" + i);
//            params.setNoticeYn(false);
//            Long id = boardService.savePost(params);
//            System.out.println("생성된 게시글 ID : " + id);
//        }
    }
}

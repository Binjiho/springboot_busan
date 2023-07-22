package com.example.demo.board.post;

import com.example.demo.admin.board.BoardMapper;
import com.example.demo.admin.board.BoardRequest;
import com.example.demo.admin.board.BoardResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardMapperTests {
    @Autowired
    BoardMapper boardMapper;

//    @Test
//    void save() {
//        BoardRequest params = new BoardRequest();
//        params.setTitle("1번 게시글 제목");
//        params.setContent("1번 게시글 내용");
//        params.setWriter("테스터");
//        params.setNoticeYn(false);
//        boardMapper.save(params);
//
//        List<BoardResponse> posts = boardMapper.findAll();
//        System.out.println("전체 게시글 개수는 : " + posts.size() + "개입니다.");
//    }

    @Test
    void findById() {
        BoardResponse post = boardMapper.findById(1L);
        try {
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void update(){
//        BoardRequest params = new BoardRequest();
//        params.setId(1L);
//        params.setTitle("1번 게시글 제목 수정합니다.");
//        params.setContent("1번 게시글 내용 수정합니다.");
//        params.setWriter("도뎡이");
//        params.setNoticeYn(true);
//        boardMapper.update(params);
//
//        BoardResponse post = boardMapper.findById(1L);
//        try {
//            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
//            System.out.println(postJson);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
    }

//    @Test
//    void delete() {
//        System.out.println("삭제 이전의 전체 게시글 개수는 : " + boardMapper.findAll().size() + "개입니다.");
//        boardMapper.deleteById(1L);
//        System.out.println("삭제 이후의 전체 게시글 개수는 : " + boardMapper.findAll().size() + "개입니다.");
//    }

}

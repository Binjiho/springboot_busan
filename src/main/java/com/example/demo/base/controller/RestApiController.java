package com.example.demo.base.controller;

import com.example.demo.admin.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RestApiController {

    private final BoardService boardService;

    @GetMapping("/members")
    //@ResponseBody //메시지 컨버터(Message Converter)에 의해 화면(HTML)이 아닌 리턴 타입에 해당하는 데이터 자체를 리턴
    public List<Map<String,Object>> findAllMember() {
        List<Map<String,Object>> members = new ArrayList<>();

        for (int i=0; i<20; i++){
            Map<String, Object> member = new HashMap<>();
            member.put("id",i);
            member.put("name",i+"번 개발자");
            member.put("age",10+i);
            members.add(member);
        }
        return members;
    }

//    @GetMapping("/boards")
//    //@ResponseBody //메시지 컨버터(Message Converter)에 의해 화면(HTML)이 아닌 리턴 타입에 해당하는 데이터 자체를 리턴
//    public PagingResponse<BoardResponse> findAllBoards() {
//        return boardService.findAllPost();
//    }
}

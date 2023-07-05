package com.example.demo.base.controller;

import com.example.demo.admin.board.service.BoardService;
import com.example.demo.admin.reservation.ReservationResponse;
import com.example.demo.admin.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RestApiController {
    private final ReservationService reservationService;
    private BoardService boardService; // private final VS autowired

    /**
     * json data
     *
     * @return
     */
    @GetMapping("/api/reservation/list")
    @ResponseBody
    public List<Map<String, Object>> apiReservationList(){
        List<ReservationResponse> list = reservationService.findAllPost();
        List<Map<String,Object>> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> items = new HashMap<>();
            items.put("id", list.get(i).getId());
            items.put("name", list.get(i).getTitle());
            items.put("status", list.get(i).getStatus());
            items.put("start_date", list.get(i).getStartDate());
            items.put("ord", list.get(i).getOrd());
            result.add(items);
        }

        return result;
    }

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
}

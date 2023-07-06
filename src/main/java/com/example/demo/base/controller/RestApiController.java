package com.example.demo.base.controller;

import com.example.demo.admin.board.service.BoardService;
import com.example.demo.admin.reservation.ReservationRequest;
import com.example.demo.admin.reservation.ReservationResponse;
import com.example.demo.admin.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
     * reservation
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
            items.put("title", list.get(i).getTitle());
            items.put("start", list.get(i).getStartDate());
            items.put("end", list.get(i).getStartDate());
            items.put("status", list.get(i).getStatus());
            items.put("ord", list.get(i).getOrd());
            result.add(items);
        }
        return result;
    }

    @PostMapping("/api/reservation/list/detail")
    @ResponseBody
    public List<Map<String, Object>> apiReservationListDetail(@RequestBody final ReservationRequest param){
        List<ReservationResponse> list = reservationService.findPost(param);

        List<Map<String,Object>> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> items = new HashMap<>();
            items.put("id", list.get(i).getId());
            items.put("title", list.get(i).getTitle());
            items.put("start", list.get(i).getStartDate());
            items.put("end", list.get(i).getStartDate());
            items.put("status", list.get(i).getStatus());
            items.put("ord", list.get(i).getOrd());
            result.add(items);
        }
        return result;
    }

    @PostMapping("/api/reservation/update")
    @ResponseBody
    public Long apiReservationUpdate(@RequestBody final ReservationRequest param){
        Long result = reservationService.updatePost(param);
        return result;
    }

}

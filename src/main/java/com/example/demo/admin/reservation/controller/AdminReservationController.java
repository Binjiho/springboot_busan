package com.example.demo.admin.reservation.controller;

import com.example.demo.admin.reservation.ReservationDto;
import com.example.demo.admin.reservation.ReservationRequest;
import com.example.demo.admin.reservation.service.ReservationService;
import com.example.demo.base.controller.BaseController;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminReservationController extends BaseController {

    private final ReservationService reservationService;

    @GetMapping("/reservation")
    public String openAdminReservationList(Model model){
        return "admin/reservation/list";
    }


    /**
     * 스케쥴 생성
     * TODO : spring batch로 일자 간격으로 생성
     * @param params
     * @return
     */
    @PostMapping("/reservation/save")
    public String saveReservation(final ReservationRequest params) {
        List<ReservationDto> reservationDtoList = new ArrayList<>();
        List<String> roomsList = params.getRooms();
        for(int i=0; i<roomsList.size(); i++){
            List<String> listTitleStatusOrd = Arrays.asList(roomsList.get(i).split("&&"));

            ReservationDto reservationDto = ReservationDto.builder()
                    .title(listTitleStatusOrd.get(0))
                    .status(Integer.valueOf(listTitleStatusOrd.get(1)))
                    .startDate(params.getStartDate())
                    .ord(Integer.valueOf(listTitleStatusOrd.get(2)))
                    .build();
            reservationDtoList.add(reservationDto);
        }
        reservationService.savePost(reservationDtoList);
        return "redirect:/admin/reservation";

        //stream
//        List<String> listTitleStatusOrd = roomsList.stream()
//                .filter(item -> item.contains("kp"))
//                .collect(Collectors.toList());
    }

}

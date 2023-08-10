package com.example.demo.admin.reservation.controller;

import com.example.demo.admin.reservation.dto.ReservationDto;
import com.example.demo.admin.reservation.ReservationRequest;
import com.example.demo.admin.reservation.entity.ReservationEntity;
import com.example.demo.admin.reservation.service.ReservationService;
import com.example.demo.base.controller.BaseController;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class AdminReservationController extends BaseController {

    private final ReservationService reservationService;

    @GetMapping("/admin/reservation")
    public String openAdminReservationList(Model model){
        return "admin/reservation/list";
    }

    /**
     * 스케쥴 생성
     * TODO : spring batch로 일자 간격으로 생성
     * @param reservationDto
     * @return
     */
    @PostMapping("/admin/reservation/save")
    public String saveReservation(final ReservationDto reservationDto) {
        String[] roomNmArr = reservationDto.getRooms().split(",");
        for(int i=0; i<roomNmArr.length; i++){
            ReservationDto dto = ReservationDto
                    .builder()
                    .title(roomNmArr[i])
                    .status(1)
                    .start(reservationDto.getStart())
                    .ord(i)
                    .build();
            reservationService.savePost(dto);
        }
        return "redirect:/admin/reservation";
    }

    /**
     * json data
     * reservation
     * @return
     */
    @GetMapping("/api/reservation/list")
    @ResponseBody
    public List<ReservationDto> apiReservationList(){
        List<ReservationDto> result = reservationService.findAll();
        return result;
    }

    @PostMapping("/api/reservation/list/detail")
    @ResponseBody
    public List<ReservationDto> apiReservationListDetail(@RequestBody final ReservationDto reservationDto){
        List<ReservationDto> result = reservationService.findByStartDate(reservationDto);
        return result;
    }
    @PostMapping("/api/reservation/update")
    @ResponseBody
    public Long apiReservationUpdate(@RequestBody final ReservationDto reservationDto){
        Long result = reservationService.updatePost(reservationDto);
        return result;
    }

}

package com.example.demo.project.reservation.controller;

import com.example.demo.base.controller.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController extends BaseController {

//    /**
//     * 실시간 예약 조회 페이지
//     * @param model
//     * @return
//     */
//    @GetMapping("/list")
//    public String openReservationList(Model model){
//        return "project/reservation/list";
//    }
//
//    /**
//     * 예약 안내 페이지
//     * @param model
//     * @return
//     */
//    @GetMapping("/guide")
//    public String openReservationGuide(Model model){
//        return "project/reservation/guide";
//    }
//
//    /**
//     * 예약 조회 페이지
//     * @param model
//     * @return
//     */
//    @GetMapping("/check")
//    public String openReservationCheck(Model model){
//        return "project/reservation/check";
//    }
}

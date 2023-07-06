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


    //스케쥴 생성
    @PostMapping("/reservation/save")
    public String saveReservation(final ReservationRequest params, Model model) {
//        return params.toString();
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
//
//        ReservationService.savePost(params);
//        MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/admin/board/list", RequestMethod.GET, null);
//        return showAlertAndRedirect(message, model);
    }


//    //게시판 수정
//    @PostMapping("/admin/board/update")
//    public String updateBoard(final BoardRequest params){
//        boardService.updatePost(params);
//        return "redirect:/admin/board/list";
//    }
//
//    //게시판 삭제
//    @PostMapping("/admin/board/delete")
//    public String deleteBoard(@RequestParam final Long id){
//        boardService.deletePost(id);
//        return "redirect:/admin/board/list";
//    }

}

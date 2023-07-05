package com.example.demo.admin.reservation.controller;

import com.example.demo.admin.reservation.service.ReservationService;
import com.example.demo.base.controller.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminReservationController extends BaseController {

    private ReservationService reservationService;

    @GetMapping("/reservation")
    public String openAdminReservationList(Model model){
        return "admin/reservation/list";
    }



    //    @GetMapping("/admin/board/list")
//    public String openBoardList(@ModelAttribute("params") final SearchDto params, Model model){
//        PagingResponse<BoardResponse> boardList = boardService.findAllPost(params);
//        model.addAttribute("boardList", boardList);
//        return "admin/board/list";
//    }
//
//    //게시판 작성 페이지
//    @GetMapping("/admin/board/write")
//    public String openboardWrite(@RequestParam(value = "id", required = false) final Long id, Model model) {
//        if (id != null) {
//            BoardResponse item = boardService.findPostById(id);
//            model.addAttribute("item", item);
//        }
//        return "admin/board/write";
//    }
//
//    //게시판 생성
//    @PostMapping("/admin/board/save")
//    public String saveBoard(final BoardRequest params, Model model) {
//        boardService.savePost(params);
//        MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/admin/board/list", RequestMethod.GET, null);
//        return showAlertAndRedirect(message, model);
//    }
//
//    //게시판 뷰 페이지
//    @GetMapping("/admin/board/view")
//    public String openBoardView(@RequestParam final Long id, Model model){
//        BoardResponse item = boardService.findPostById(id);
//        model.addAttribute("item", item);
//        return "admin/board/view";
//    }
//
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

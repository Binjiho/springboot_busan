package com.example.demo.project.main.controller;

import com.example.demo.admin.board.BoardDetailResponse;
import com.example.demo.admin.board.BoardRequest;
import com.example.demo.admin.board.BoardResponse;
import com.example.demo.admin.board.service.BoardDetailService;
import com.example.demo.base.controller.BaseController;
import com.example.demo.base.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class MainController extends BaseController {

    private final BoardDetailService boardDetailService;
    @GetMapping("/")
    public String mainPage(Model model){

        //load Banner
        Long boardId = 1L; // HOME: 1L , OUT: 1001L
        List<BoardDetailResponse> bannerTop = boardDetailService.findAllPostById(boardId);
        model.addAttribute("bannerTop", bannerTop);
        return "project/main/index";
    }
    /* about */
    /**
     * 소개 전경 페이지
     * @return
     */
    @GetMapping("/about/introduce")
    public String openAboutPage(Model model){
        return "project/about/introduce";
    }

    /**
     * 이용 안내 페이지
     * @return
     */
    @GetMapping("/about/informationUse")
    public String openInformationUsePage(){
        return "project/about/informationUse";
    }

    /* rooms */
    @GetMapping("/rooms/kp")
    public String openRoomsKP(Model model){
        List<Objects> bannerTop = new ArrayList<>();
        model.addAttribute("bannerTop", bannerTop);
        return "project/rooms/kp";
    }

    @GetMapping("/rooms/ky")
    public String openRoomsKY(Model model){
        List<Objects> bannerTop = new ArrayList<>();
        model.addAttribute("bannerTop", bannerTop);
        return "project/rooms/ky";
    }

    @GetMapping("/rooms/cw")
    public String openRoomsCW(Model model){
        List<Objects> bannerTop = new ArrayList<>();
        model.addAttribute("bannerTop", bannerTop);
        return "project/rooms/cw";
    }

    @GetMapping("/rooms/mp")
    public String openRoomsMP(Model model){
        List<Objects> bannerTop = new ArrayList<>();
        model.addAttribute("bannerTop", bannerTop);
        return "project/rooms/mp";
    }

    @GetMapping("/rooms/my")
    public String openRoomsMY(Model model){
        List<Objects> bannerTop = new ArrayList<>();
        model.addAttribute("bannerTop", bannerTop);
        return "project/rooms/my";
    }

    /* notice */
    /**
     * 공지사항 페이지
     * @return
     */
    @GetMapping("/notice/list")
    public String openNoticeListPage(){
        return "project/notice/list";
    }

    /* review */
    /**
     * 이용후기 페이지
     * @return
     */
    @GetMapping("/review/list")
    public String openReviewListPage(){
        return "project/review/list";
    }

    //이용후기 작성 페이지
    @GetMapping("/review/write")
    public String openReviewdWritePage(@RequestParam(value = "id", required = false) final Long id, Model model) {
//        if (id != null) {
//            BoardResponse item = reviewService.findPostById(id);
//            model.addAttribute("item", item);
//        }
        return "project/review/write";
    }

    //이용후기 생성
//    @PostMapping("/review/save")
//    public String saveReview(final ReviewRequest params, Model model) {
//        reviewService.savePost(params);
//        return "redirect:/project/review/list";
//    }

    //이용후기 뷰 페이지
    @GetMapping("/review/detail")
    public String openReviewDetail(@RequestParam final Long id, Model model){
//        ReviewResponse item = reviewService.findPostById(id);
//        model.addAttribute("item", item);
        return "project/review/detail";
//        return "project/review/detail?id={id}";
    }

    /* reservation */
    /**
     * 실시간 예약 조회 페이지
     * @param model
     * @return
     */
    @GetMapping("/reservation/list")
    public String openReservationList(Model model){
        return "project/reservation/list";
    }

    /**
     * 예약 안내 페이지
     * @param model
     * @return
     */
    @GetMapping("/reservation/guide")
    public String openReservationGuide(Model model){
        return "project/reservation/guide";
    }

    /**
     * 예약 조회 페이지
     * @param model
     * @return
     */
    @GetMapping("/reservation/check")
    public String openReservationCheck(Model model){
        return "project/reservation/check";
    }

    /* location */
    /**
     * 오시는길 페이지
     * @return
     */
    @GetMapping("/location")
    public String openLocationPage(){
        return "project/location/location";
    }

    /* privacy */
    @GetMapping("/privacy/personal")
    public String openPersonalPage(){
        return "project/privacy/personal";
    }

    @GetMapping("/privacy/useTerms")
    public String openUseTermsPage(){
        return "project/privacy/useTerms";
    }

    @GetMapping("/privacy/email")
    public String openEmailPage(){
        return "project/privacy/email";
    }

}

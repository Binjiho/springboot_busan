package com.example.demo.project.main.controller;

import com.example.demo.admin.board.BoardDetailResponse;
import com.example.demo.admin.board.service.BoardDetailService;
import com.example.demo.base.controller.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController extends BaseController {

    private final BoardDetailService boardDetailService;
    @GetMapping("/")
    public String mainPage(Model model){

        //load Banner
        List<BoardDetailResponse> bannerTop = boardDetailService.findAllPostById(1L);
        model.addAttribute("bannerTop", bannerTop);
        return "project/main/index";
    }

    @GetMapping("/about/introduce")
    public String aboutPage(){
        return "project/about/introduce";
    }

}

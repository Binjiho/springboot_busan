package com.example.demo.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String mainPage(){
        return "project/main/index";
    }

    @GetMapping("/about/introduce")
    public String aboutPage(){
        return "project/about/introduce";
    }

}

package com.example.demo.project.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/banner")
public class HomeController {
    @GetMapping({"","/index"})
    public String openIndexPage(){
        return "index";
    }
}

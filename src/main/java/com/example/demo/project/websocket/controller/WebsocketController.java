package com.example.demo.project.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsocketController {

    @GetMapping({"/websocket","/websocket/index.html"})
    public String openWebsocketPage(){
        return "/project/websocket/index.html";
    }
}

package com.example.demo.base.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RestApiController {
    private final Environment environment;
    private final ApplicationContext applicationContext;

    @GetMapping("/profile")
    public String[] getActiveProfiles() {
        System.out.println(Arrays.toString( environment.getActiveProfiles() ));
        return environment.getActiveProfiles();
    }
}

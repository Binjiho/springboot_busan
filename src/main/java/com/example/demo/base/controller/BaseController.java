package com.example.demo.base.controller;

import com.example.demo.base.config.WebMvcConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseController extends WebMvcConfig {
//    private String connectPath = "/files/**"; // http://localhost:8080/files/1 경로가
//    private String resourcePath = "file:///C:/dev/tools/local/images/upload-files/"; // file:///C:/dev/tools/local/images/upload-files/230704/1 로 매핑된다.
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(connectPath)
//                .addResourceLocations(resourcePath);
//    }
}

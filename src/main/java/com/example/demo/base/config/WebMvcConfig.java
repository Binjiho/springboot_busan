package com.example.demo.base.config;


import com.example.demo.base.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private String connectPath = "/files/**"; // http://localhost:8080/files/1 경로가
    private String resourcePath = "file:///C:/dev/tools/local/images/upload-files/"; // file:///C:/dev/tools/local/images/upload-files/230704/1 로 매핑된다.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(connectPath)
                .addResourceLocations(resourcePath);
    }

}
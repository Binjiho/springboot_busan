package com.example.demo.admin.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private Boolean noticeYn;
}

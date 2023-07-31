package com.example.demo.base.paging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDto {
    private int page;
    private int size;
    private String searchKeyword; // 검색 키워드
    private String searchType;    // 검색 타입

    public PageRequestDto(){
        this.page = 1;
        this.size = 10;
    }

    public Pageable getPageable(Sort sort){
        // 페이지 번호가 0부터 시작한다는 점을 감안해 1페이지의 경우 0이 될수 있도록 page -1로 작성해준다
        return PageRequest.of(page-1, size, sort);
    }
}


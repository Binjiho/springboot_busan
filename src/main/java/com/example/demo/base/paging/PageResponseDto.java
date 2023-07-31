package com.example.demo.base.paging;

import lombok.Data;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@Data
public class PageResponseDto<DTO> {

    private List<DTO> dtoList; // DTO리스트
    private long totalCount; //총 게시글 수
    private int totalPage; // 총 페이지 번호
    private int page; // 현재 페이지 번호
    private int size; // 목록 사이즈
    private int start,end; // 시작페이지,끝페이지 번호
    private boolean prev, next; // 이전, 다음

    // Function<EN,DTO> : 엔티티 객체들을 DTO로 변환해주는 기능
    public PageResponseDto(Page<DTO> result){
        dtoList = result.stream().collect(Collectors.toList());
        totalPage = result.getTotalPages();
        totalCount = result.getTotalElements();
        makePageList(result.getPageable());
    }

    private void makePageList(Pageable pageable){
        this.page = pageable.getPageNumber()+1;
        this.size = pageable.getPageSize();

        // temp end page
        int tempEnd = (int)(Math.ceil(page / (double)size)) * size;
        start = tempEnd-(size-1);
        end = Math.min(totalPage, tempEnd);
        prev = start > 1;
        next = totalPage > tempEnd;
    }
}

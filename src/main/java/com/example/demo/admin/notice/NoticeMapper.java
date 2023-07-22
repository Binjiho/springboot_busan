package com.example.demo.admin.notice;

import com.example.demo.base.paging.SearchDto;
import com.example.demo.admin.notice.NoticeRequest;
import com.example.demo.admin.notice.NoticeResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    /**
     * BE
     * 게시글 저장
     * @param params - 게시글 정보
     */
    void save(NoticeRequest params);

    /**
     * BE
     * 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    NoticeResponse findById(Long id);

    /**
     * BE
     * 게시글 수정
     * @param params - 게시글 정보
     */
    void update(NoticeRequest params);

    /**
     * BE
     * 게시글 삭제
     * @param id - PK
     */
    void deleteById(Long id);

    /**
     * BE
     * 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<NoticeResponse> findAll(SearchDto params);

    /**
     * FE
     * 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<NoticeResponse> findAllFront(SearchDto params);

    /**
     * BE
     * 게시글 수 카운팅
     * @return 게시글 수
     */
    int count(SearchDto params);

    /**
     * FE
     * 게시글 수 카운팅
     * @return 게시글 수
     */
    int countFront(SearchDto params);
}

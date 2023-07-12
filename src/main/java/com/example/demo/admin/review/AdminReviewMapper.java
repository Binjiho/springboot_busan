package com.example.demo.admin.review;

import com.example.demo.base.paging.SearchDto;
import com.example.demo.project.review.ReviewRequest;
import com.example.demo.project.review.ReviewResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminReviewMapper {
    /**
     * 게시글 저장
     * @param params - 게시글 정보
     */
    void save(ReviewRequest params);

    /**
     * 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    ReviewResponse findById(Long id);

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     */
    void update(ReviewRequest params);

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     */
    void updateWithFiles(ReviewRequest params);

    /**
     * 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<ReviewResponse> findAll(SearchDto params);

    /**
     * 게시글 수 카운팅
     * @return 게시글 수
     */
    int count(SearchDto params);
}

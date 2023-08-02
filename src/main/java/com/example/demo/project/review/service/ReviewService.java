package com.example.demo.project.review.service;

import com.example.demo.base.file.dto.FileDto;
import com.example.demo.base.paging.Pagination;
import com.example.demo.base.paging.PagingResponse;
import com.example.demo.base.paging.SearchDto;
import com.example.demo.project.review.ReviewMapper;
import com.example.demo.project.review.ReviewRequest;
import com.example.demo.project.review.ReviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewMapper reviewMapper;

    /**
     * 이용후기 저장
     * @param params - 게시글 정보
     * @return Generated PK
     */
    @Transactional
    public Long savePost(final ReviewRequest params, final List<FileDto> files) {

        if (!CollectionUtils.isEmpty(files)) {
            for (FileDto file : files) {
                params.setOriginalName(file.getOriginalName());
                params.setSaveName(file.getSaveName());
                params.setUploadPath(file.getUploadPath());
            }
        }

        reviewMapper.save(params);
        return params.getId();
    }

    /**
     * 이용후기 상세정보 조회
     * @param id - PK
     * @return 이용후기 상세정보
     */
    public ReviewResponse findPostById(final Long id) {
        return reviewMapper.findById(id);
    }

    /**
     * 이용후기 수정
     * @param params - 게시글 정보
     * @return PK
     */
    @Transactional
    public Long updatePost(final ReviewRequest params, final List<FileDto> files) {

        if (!CollectionUtils.isEmpty(files)) {
            for (FileDto file : files) {
                params.setOriginalName(file.getOriginalName());
                params.setSaveName(file.getSaveName());
                params.setUploadPath(file.getUploadPath());
            }
            reviewMapper.updateWithFiles(params);
        }else{
            reviewMapper.update(params);
        }
        return params.getId();
    }

    /**
     * 이용후기 삭제
     * @param id - PK
     * @return PK
     */
    public Long deletePost(final Long id) {
        reviewMapper.deleteById(id);
        return id;
    }

    /**
     * 이용후기 리스트 조회
     * @param params - search conditions
     * @return list & pagination information
     */
    public PagingResponse<ReviewResponse> findAllPost(final SearchDto params) {

        // 조건에 해당하는 데이터가 없는 경우, 응답 데이터에 비어있는 리스트와 null을 담아 반환
        int count = reviewMapper.count(params);
        if (count < 1) {
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        // Pagination 객체를 생성해서 페이지 정보 계산 후 SearchDto 타입의 객체인 params에 계산된 페이지 정보 저장
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        // 계산된 페이지 정보의 일부(limitStart, recordSize)를 기준으로 리스트 데이터 조회 후 응답 데이터 반환
        List<ReviewResponse> list = reviewMapper.findAll(params);
        return new PagingResponse<>(list, pagination);
    }
}

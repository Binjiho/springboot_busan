package com.example.demo.admin.notice.service;

import com.example.demo.admin.notice.NoticeMapper;
import com.example.demo.admin.notice.NoticeRequest;
import com.example.demo.admin.notice.NoticeResponse;
import com.example.demo.base.paging.Pagination;
import com.example.demo.base.paging.PagingResponse;
import com.example.demo.base.paging.SearchDto;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

public class NoticeOldService {
//    private final NoticeMapper noticeMapper;

//    /**
//     * BE
//     * 공지사항 리스트 조회
//     * @param params - search conditions
//     * @return list & pagination information
//     */
//    public PagingResponse<NoticeResponse> findAllPost(final SearchDto params) {
//
//        // 조건에 해당하는 데이터가 없는 경우, 응답 데이터에 비어있는 리스트와 null을 담아 반환
//        int count = noticeMapper.count(params);
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }
//
//        // Pagination 객체를 생성해서 페이지 정보 계산 후 SearchDto 타입의 객체인 params에 계산된 페이지 정보 저장
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//
//        // 계산된 페이지 정보의 일부(limitStart, recordSize)를 기준으로 리스트 데이터 조회 후 응답 데이터 반환
//        List<NoticeResponse> list = noticeMapper.findAll(params);
//        return new PagingResponse<>(list, pagination);
//    }
//
//    /**
//     * FE
//     * 공지사항 리스트 조회
//     * @param params - search conditions
//     * @return list & pagination information
//     */
//    public PagingResponse<NoticeResponse> findAllPostFront(final SearchDto params) {
//
//        // 조건에 해당하는 데이터가 없는 경우, 응답 데이터에 비어있는 리스트와 null을 담아 반환
//        int count = noticeMapper.countFront(params);
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }
//
//        // Pagination 객체를 생성해서 페이지 정보 계산 후 SearchDto 타입의 객체인 params에 계산된 페이지 정보 저장
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//
//        // 계산된 페이지 정보의 일부(limitStart, recordSize)를 기준으로 리스트 데이터 조회 후 응답 데이터 반환
//        List<NoticeResponse> list = noticeMapper.findAllFront(params);
//        return new PagingResponse<>(list, pagination);
//    }
//
//    /**
//     * BE
//     * 공지사항 저장
//     * @param params - 게시글 정보
//     * @return Generated PK
//     */
//    @Transactional
//    public Long savePost(final NoticeRequest params) {
//        noticeMapper.save(params);
//        return params.getId();
//    }
//
//    /**
//     * BE
//     * 공지사항 상세정보 조회
//     * @param id - PK
//     * @return 공지사항 상세정보
//     */
//    public NoticeResponse findPostById(final Long id) {
//        return noticeMapper.findById(id);
//    }
//
//    /**
//     * BE
//     * 공지사항 수정
//     * @param params - 게시글 정보
//     * @return PK
//     */
//    @Transactional
//    public Long updatePost(final NoticeRequest params) {
//        noticeMapper.update(params);
//        return params.getId();
//    }
}

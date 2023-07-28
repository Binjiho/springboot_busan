package com.example.demo.admin.notice.service;

import com.example.demo.admin.notice.NoticeMapper;
import com.example.demo.admin.notice.NoticeRequest;
import com.example.demo.admin.notice.NoticeResponse;
import com.example.demo.admin.notice.dto.NoticeDto;
import com.example.demo.admin.notice.entity.NoticeEntity;
import com.example.demo.admin.notice.repository.NoticeRepository;
import com.example.demo.base.file.FileRequest;
import com.example.demo.base.paging.Pagination;
import com.example.demo.base.paging.PagingResponse;
import com.example.demo.base.paging.SearchDto;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    /**
     * FE
     * 공지사항 리스트 조회
     * @param params - search conditions
     * @return list & pagination information
     */
    public Page<NoticeDto> getPageList(Pageable pageable) {
        Page<NoticeEntity> noticeEntities = noticeRepository.findAll(pageable);

        Page<NoticeDto> result = noticeEntities.map(NoticeDto::toDto);

        return result;
    }
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

}

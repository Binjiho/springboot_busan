package com.example.demo.admin.notice.service;

import com.example.demo.admin.notice.dto.NoticeDto;
import com.example.demo.admin.notice.entity.NoticeEntity;
import com.example.demo.admin.notice.entity.QNoticeEntity;
import com.example.demo.admin.notice.repository.NoticeRepository;
import com.example.demo.base.paging.*;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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
    public PageResponseDto<NoticeDto> getPageList(PageRequestDto requestDto) {
        Pageable pageable = requestDto.getPageable(Sort.by("id").descending());

        // 검색 조건 처리
        BooleanBuilder booleanBuilder = getSearch(requestDto);

        Page<NoticeEntity> noticeEntities = noticeRepository.findAll(booleanBuilder, pageable);

        Page<NoticeDto> noticeDtos = noticeEntities.map(NoticeDto::toDto);

        return new PageResponseDto<>(noticeDtos);
    }

    private BooleanBuilder getSearch(PageRequestDto requestDto){

        String searchType = requestDto.getSearchType();

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        QNoticeEntity qNoticeEntity = QNoticeEntity.noticeEntity;

        String searchKeyword = requestDto.getSearchKeyword();

        BooleanExpression expression = qNoticeEntity.id.gt(0L); // gno > 0 조건만 생성

        booleanBuilder.and(expression);

        if(searchType == null || searchType.trim().length() == 0 ){ // 검색 조건이 없는경우
            return booleanBuilder;
        }

        // 검색 조건 작성
        BooleanBuilder conditionBuilder = new BooleanBuilder();

        if(searchType.contains("t")){
            conditionBuilder.or(qNoticeEntity.title.contains(searchKeyword));
        }
        if(searchType.contains("c")){
            conditionBuilder.or(qNoticeEntity.content.contains(searchKeyword));
        }
        if(searchType.contains("w")){
            conditionBuilder.or(qNoticeEntity.writer.contains(searchKeyword));
        }

        // 모든 조건 통합
        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;
    }

    public NoticeDto findPostById(final Long id) {
        Optional<NoticeEntity> optionalNoticeEntity = Optional.ofNullable(noticeRepository.findById(id).orElseThrow(() -> {
          return new IllegalArgumentException("ID가 존재하지 않습니다");
        }));
        if (optionalNoticeEntity.isPresent()){
            NoticeDto noticeDto = NoticeDto.toDto(optionalNoticeEntity.get());
            return noticeDto;
        }
        return null;
    }

    @Transactional
    public void savePost(NoticeDto noticeDto){
        NoticeEntity noticeEntity = NoticeEntity.builder()
                .title(noticeDto.getTitle())
                .content(noticeDto.getContent())
                .writer(noticeDto.getWriter())
                .ord(0)
                .deleteYn(0)
                .startDate(noticeDto.getStartDate())
                .endDate(noticeDto.getEndDate())
                .build();

        Long noticeId = noticeRepository.save(noticeEntity).getId();

        Optional<NoticeEntity> optionalNoticeEntity
                = Optional.ofNullable(noticeRepository.findById(noticeId).orElseThrow(() -> {
            return new IllegalArgumentException("아이디를 찾을 수 없습니다.");
        }));

//        if (!optionalNoticeEntity.isPresent()) {
//            return 0;
//        }
//        return 1;
    }


}

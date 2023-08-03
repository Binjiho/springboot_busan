package com.example.demo.admin.review.service;

import com.example.demo.admin.review.dto.ReviewDto;
import com.example.demo.admin.review.dto.ReviewWithFileDto;
import com.example.demo.admin.review.entity.QReviewEntity;
import com.example.demo.admin.review.entity.ReviewEntity;
import com.example.demo.admin.review.repository.ReviewRepository;
import com.example.demo.base.file.dto.FileDto;
import com.example.demo.base.file.repository.FileRepository;
import com.example.demo.base.paging.*;
import com.example.demo.base.file.entity.FileEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminReviewService {
    private final ReviewRepository reviewRepository;
    private final FileRepository fileRepository;

    /**
     * FE
     * @param requestDto
     * @return
     */
    public PageResponseDto<ReviewDto> getPageList(PageRequestDto requestDto) {
        Pageable pageable = requestDto.getPageable(Sort.by("id").descending());

        // 검색 조건 처리
        BooleanBuilder booleanBuilder = getSearch(requestDto);

//        List<ReviewWithFileDto> reviewWithFileDtos = reviewRepository.findReviewWithFiles(booleanBuilder, pageable);
//        for(ReviewWithFileDto items : reviewWithFileDtos){
//            System.out.println(items.getId());
//            System.out.println(items.getcCode());
//            System.out.println(items.getSaveName());
//        }

        Page<ReviewEntity> reviewEntities = reviewRepository.findAll(booleanBuilder, pageable);
        Page<ReviewDto> reviewDtos = reviewEntities.map(ReviewDto::toDto);

        return new PageResponseDto<>(reviewDtos);
    }

    private BooleanBuilder getSearch(PageRequestDto requestDto){

        String searchType = requestDto.getSearchType();

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        QReviewEntity qReviewEntity = QReviewEntity.reviewEntity;

        String searchKeyword = requestDto.getSearchKeyword();

        BooleanExpression expression = qReviewEntity.id.gt(0L); // gno > 0 조건만 생성

        booleanBuilder.and(expression);

        if(searchType == null || searchType.trim().length() == 0 ){ // 검색 조건이 없는경우
            return booleanBuilder;
        }

        // 검색 조건 작성
        BooleanBuilder conditionBuilder = new BooleanBuilder();

        if(searchType.contains("t")){
            conditionBuilder.or(qReviewEntity.title.contains(searchKeyword));
        }
        if(searchType.contains("c")){
            conditionBuilder.or(qReviewEntity.content.contains(searchKeyword));
        }
        if(searchType.contains("w")){
            conditionBuilder.or(qReviewEntity.writer.contains(searchKeyword));
        }

        // 모든 조건 통합
        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;
    }

    public ReviewDto findPostById(final Long id) {
        Optional<ReviewEntity> optionalReviewEntity = Optional.ofNullable(reviewRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("ID가 존재하지 않습니다");
        }));
        if (optionalReviewEntity.isPresent()){
            ReviewDto reviewDto = ReviewDto.toDto(optionalReviewEntity.get());
            return reviewDto;
        }
        return null;
    }

    @Transactional
    public void savePost(ReviewDto reviewDto, final List<FileDto> files){
        ReviewEntity reviewEntity = ReviewEntity.builder()
                .title(reviewDto.getTitle())
                .writer(reviewDto.getWriter())
                .content(reviewDto.getContent())
                .password(reviewDto.getPassword())
                .secretYn(reviewDto.getSecretYn())
                .ord(reviewDto.getOrd())
                .deleteYn(reviewDto.getDeleteYn())
                .isFile(reviewDto.getIsFile())
                .cCode(reviewDto.getCCode())
                .createdDate(reviewDto.getCreatedDate())
                .modifiedDate(reviewDto.getModifiedDate())
                .build();

        Long Id = reviewRepository.save(reviewEntity).getId();

        Optional<ReviewEntity> optionalReviewEntity
                = Optional.ofNullable(reviewRepository.findById(Id).orElseThrow(() -> {
            return new IllegalArgumentException("아이디를 찾을 수 없습니다.");
        }));

        if(reviewDto.getIsFile()>0){
            for (FileDto file : files) {
                FileEntity fileEntity = FileEntity.builder()
                        .cCode(reviewDto.getCCode())
                        .saveName(file.getSaveName())
                        .originalName(file.getOriginalName())
                        .uploadPath(file.getUploadPath())
                        .boardId(Id)
                        .build();
                fileRepository.save(fileEntity);
            }
        }
    }

    @Transactional
    public void updatePost(final ReviewDto reviewDto, final List<FileDto> files) {

        Long reviewId = reviewDto.getId();
        Optional<ReviewEntity> optionalReviewEntity
                = Optional.ofNullable(reviewRepository.findById(reviewId).orElseThrow(() -> {
            return new IllegalArgumentException("아이디를 찾을 수 없습니다.");
        }));
        if(optionalReviewEntity.isPresent()){
            ReviewEntity reviewEntity = ReviewEntity.builder()
                    .id(reviewDto.getId())
                    .title(reviewDto.getTitle())
                    .writer(reviewDto.getWriter())
                    .content(reviewDto.getContent())
                    .password(reviewDto.getPassword())
                    .secretYn(reviewDto.getSecretYn())
                    .ord(reviewDto.getOrd())
                    .deleteYn(reviewDto.getDeleteYn())
                    .isFile(reviewDto.getIsFile())
                    .cCode(reviewDto.getCCode())
                    .createdDate(reviewDto.getCreatedDate())
                    .modifiedDate(reviewDto.getModifiedDate())
                    .build();
            reviewRepository.save(reviewEntity);
        }
        if(reviewDto.getIsFile()>0){
            for (FileDto file : files) {
                FileEntity fileEntity = FileEntity.builder()
                        .id(file.getId())
                        .cCode(reviewDto.getCCode())
                        .saveName(file.getSaveName())
                        .originalName(file.getOriginalName())
                        .uploadPath(file.getUploadPath())
                        .boardId(reviewDto.getId())
                        .build();
                fileRepository.save(fileEntity);
            }
        }
    }

//    @Transactional
//    public Long savePost(final ReviewRequest params, final List<FileRequest> files) {
//
//        if (!CollectionUtils.isEmpty(files)) {
//            for (FileRequest file : files) {
//                params.setOriginalName(file.getOriginalName());
//                params.setSaveName(file.getSaveName());
//                params.setUploadPath(file.getUploadPath());
//            }
//        }
//
//        reviewMapper.save(params);
//        return params.getId();
//    }
//
//    /**
//     * 이용후기 상세정보 조회
//     * @param id - PK
//     * @return 이용후기 상세정보
//     */
//    public ReviewResponse findPostById(final Long id) {
//        return reviewMapper.findById(id);
//    }
//
//    /**
//     * 이용후기 수정
//     * @param params - 게시글 정보
//     * @return PK
//     */
//    @Transactional
//    public Long updatePost(final ReviewRequest params, final List<FileRequest> files) {
//
//        if (!CollectionUtils.isEmpty(files)) {
//            for (FileRequest file : files) {
//                params.setOriginalName(file.getOriginalName());
//                params.setSaveName(file.getSaveName());
//                params.setUploadPath(file.getUploadPath());
//            }
//            reviewMapper.updateWithFiles(params);
//        }else{
//            reviewMapper.update(params);
//        }
//        return params.getId();
//    }
//
//    /**
//     * 이용후기 리스트 조회
//     * @param params - search conditions
//     * @return list & pagination information
//     */
//    public PagingResponse<ReviewResponse> findAllPost(final SearchDto params) {
//
//        // 조건에 해당하는 데이터가 없는 경우, 응답 데이터에 비어있는 리스트와 null을 담아 반환
//        int count = reviewMapper.count(params);
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }
//
//        // Pagination 객체를 생성해서 페이지 정보 계산 후 SearchDto 타입의 객체인 params에 계산된 페이지 정보 저장
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//
//        // 계산된 페이지 정보의 일부(limitStart, recordSize)를 기준으로 리스트 데이터 조회 후 응답 데이터 반환
//        List<ReviewResponse> list = reviewMapper.findAll(params);
//        return new PagingResponse<>(list, pagination);
//    }

}

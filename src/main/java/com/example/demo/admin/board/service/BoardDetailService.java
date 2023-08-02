package com.example.demo.admin.board.service;

import com.example.demo.admin.board.BoardDetailMapper;
import com.example.demo.admin.board.BoardDetailRequest;
import com.example.demo.admin.board.BoardDetailResponse;


import com.example.demo.base.file.dto.FileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardDetailService {
    private final BoardDetailMapper boardDetailMapper;

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     * @return Generated PK
     */
    @Transactional
    public Long savePost(final BoardDetailRequest params, final List<FileDto> files) {
        if (!CollectionUtils.isEmpty(files)) {
            for (FileDto file : files) {
                file.setBoard_id(params.getBoard_id());
            }
        }

        //params에 file정보 insert (단일 파일 고려)
        params.setOriginalName(files.get(0).getOriginalName());
        params.setSaveName(files.get(0).getSaveName());
        params.setUploadPath(files.get(0).getUploadPath());

        boardDetailMapper.save(params);
        return params.getId();
    }

    /**
     * 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    public BoardDetailResponse findPostById(final Long id) {

        return boardDetailMapper.findById(id);
    }

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     * @return PK
     */
//    @Transactional
//    public Long updatePost(final BoardDetailRequest params) {
//        boardDetailMapper.update(params);
//        return params.getId();
//    }

    /**
     * 게시글 삭제
     * @param id - PK
     * @return PK
     */
//    public Long deletePost(final Long id) {
//        boardDetailMapper.deleteById(id);
//        return id;
//    }

    /**
     * 게시글 리스트 조회
     * @param boardId - detail board_id(FK)
     * @return list & pagination information
     */
    public List<BoardDetailResponse> findAllPostById(final Long boardId) {

        List<BoardDetailResponse> list = boardDetailMapper.findAllById(boardId);
        return list;
    }
}

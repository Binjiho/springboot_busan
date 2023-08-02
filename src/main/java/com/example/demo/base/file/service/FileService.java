package com.example.demo.base.file.service;

import com.example.demo.admin.review.dto.ReviewDto;
import com.example.demo.base.file.dto.FileDto;
import com.example.demo.base.file.entity.FileEntity;
import com.example.demo.base.file.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileRepository fileRepository;

    public List<FileDto> getFiles(final Long boardId, int cCode) {
        List<FileDto> result = null;

        List<FileEntity> fileEntities=fileRepository.findBycCodeAndBoardId(cCode,boardId);

        if (fileEntities.size()>0){
            List<FileDto> fileDtos = fileEntities.stream().map(FileDto::toDto).collect(Collectors.toList());
            result = fileDtos;
        }
        return result;
    }
//    @Transactional
//    public void saveFiles(final Long board_Id, final List<FileDto> files) {
//        if (CollectionUtils.isEmpty(files)) {
//            return;
//        }
//        for (FileDto file : files) {
//            file.setBoard_id(board_Id);
//        }
//        fileMapper.saveAll(files);
//    }
}

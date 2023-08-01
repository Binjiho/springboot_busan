package com.example.demo.project.file.service;

import com.example.demo.project.file.repository.FileReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileReviewService {
    private final FileReviewRepository fileReviewRepository;


}

package com.example.demo.project.file.service;

import com.example.demo.project.file.repository.FileMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileMemberService {
    private final FileMemberRepository fileMemberRepository;


}

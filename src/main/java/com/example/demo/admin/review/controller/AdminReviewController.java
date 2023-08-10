package com.example.demo.admin.review.controller;

import com.example.demo.admin.review.dto.ReviewDto;
import com.example.demo.admin.review.service.AdminReviewService;
import com.example.demo.base.controller.BaseController;
import com.example.demo.base.file.dto.FileDto;
import com.example.demo.base.file.FileUtils;
import com.example.demo.base.file.service.FileService;
import com.example.demo.base.paging.PageRequestDto;
import com.example.demo.base.paging.PageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminReviewController extends BaseController {

    private final AdminReviewService reviewService;
    private final FileService fileService;
    private final FileUtils fileUtils;

    /**
     * FE
     * 이용후기 페이지
     * @return
     */
    @GetMapping("/review/list")
    public String openFEReviewListPage(@ModelAttribute("params") final PageRequestDto pageRequestDto, Model model){
        PageResponseDto<ReviewDto> list = reviewService.getPageList(pageRequestDto);
        model.addAttribute("list", list);
        return "project/review/list";
    }

    @GetMapping("/review/write")
    public String openFEReviewWritePage(@RequestParam(value = "id", required = false) final Long id, Model model) {
        ReviewDto items = null;
        List<FileDto> files = null;

        if (id != null) {
            items = reviewService.findPostById(id);
            if(items.getIsFile() > 0){
                files = fileService.getFiles(id, items.getCCode());
            }
        }
        model.addAttribute("items", items);
        return "project/review/write";
    }

    @PostMapping("/review/save")
    public String saveReview(final ReviewDto reviewDto) {
        List<FileDto> files = null;

        if(reviewDto.getIsFile() > 0){
            files = fileUtils.uploadFiles(reviewDto.getFiles());
        }
        reviewService.savePost(reviewDto,files);
        return "redirect:/review/list";
    }

    @GetMapping("/review/detail/{id}")
    public String openFEReviewDetailPage(@PathVariable("id") final Long id, Model model){
        List<FileDto> files = null;
        ReviewDto reviewDto = reviewService.findPostById(id);
        if(reviewDto.getIsFile() > 0){
            files = fileService.getFiles(id, reviewDto.getCCode());
        }
        model.addAttribute("items", reviewDto);
        model.addAttribute("files", files);
        return "project/review/detail";
    }

    @PostMapping("/review/update")
    public String updateReview(final ReviewDto reviewDto){
        List<FileDto> files = null;

        if(reviewDto.getIsFile() > 0){
            files = fileService.getFiles(reviewDto.getId(), reviewDto.getCCode());
        }

        reviewService.updatePost(reviewDto,files);

        return "redirect:/review/list";
    }

    /**
     * BE
     * 이용후기 페이지
     * @return
     */
    @GetMapping("/admin/review/list")
    public String openBEReviewListPage(@ModelAttribute("params") final PageRequestDto pageRequestDto, Model model){
        PageResponseDto<ReviewDto> list = reviewService.getPageList(pageRequestDto);
        model.addAttribute("list", list);
        return "admin/review/list";
    }

    @GetMapping("/admin/review/write")
    public String openBEReviewWritePage(@RequestParam(value = "id", required = false) final Long id, Model model) {
        ReviewDto items = null;
        List<FileDto> files = null;

        if (id != null) {
            items = reviewService.findPostById(id);
            if(items.getIsFile() > 0){
                files = fileService.getFiles(id, items.getCCode());
            }
        }
        model.addAttribute("items", items);
        return "admin/review/write";
    }

    @PostMapping("/admin/review/save")
    public String saveBEReview(final ReviewDto reviewDto) {
        List<FileDto> files = null;

        if(reviewDto.getIsFile() > 0){
            files = fileUtils.uploadFiles(reviewDto.getFiles());
        }
        reviewService.savePost(reviewDto,files);
        return "redirect:/admin/review/list";
    }

    @GetMapping("/admin/review/detail/{id}")
    public String openBEReviewDetailPage(@PathVariable("id") final Long id, Model model){
        List<FileDto> files = null;
        ReviewDto reviewDto = reviewService.findPostById(id);
        if(reviewDto.getIsFile() > 0){
            files = fileService.getFiles(id, reviewDto.getCCode());
        }
        model.addAttribute("items", reviewDto);
        model.addAttribute("files", files);
        return "admin/review/detail";
    }

    @PostMapping("/admin/review/update")
    public String updateBEReview(final ReviewDto reviewDto){
        List<FileDto> files = null;

        if(reviewDto.getIsFile() > 0){
            files = fileService.getFiles(reviewDto.getId(), reviewDto.getCCode());
        }

        reviewService.updatePost(reviewDto,files);

        return "redirect:/admin/review/list";
    }
}

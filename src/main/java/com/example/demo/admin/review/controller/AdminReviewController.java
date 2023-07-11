package com.example.demo.admin.review.controller;

import com.example.demo.base.controller.BaseController;
import com.example.demo.base.file.FileRequest;
import com.example.demo.base.file.FileUtils;
import com.example.demo.base.paging.PagingResponse;
import com.example.demo.base.paging.SearchDto;
import com.example.demo.project.review.ReviewRequest;
import com.example.demo.project.review.ReviewResponse;
import com.example.demo.project.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/review")
@RequiredArgsConstructor
public class AdminReviewController extends BaseController {

    private final ReviewService reviewService;
    private final FileUtils fileUtils;

    /**
     * 이용후기 페이지
     * @return
     */
    @GetMapping("/list")
    public String openReviewListPage(@ModelAttribute("params") final SearchDto params, Model model){
        PagingResponse<ReviewResponse> list = reviewService.findAllPost(params);
        model.addAttribute("list", list);
        return "admin/review/list";
    }

    //이용후기 작성 페이지
    @GetMapping("/write")
    public String openReviewWritePage(@RequestParam(value = "id", required = false) final Long id, Model model) {
        ReviewResponse items = null;
        if (id != null) {
            items = reviewService.findPostById(id);
        }
        model.addAttribute("items", items);
        return "admin/review/write";
    }

    //이용후기 생성
    @PostMapping("/save")
    public String saveReview(final ReviewRequest params) {
        List<FileRequest> files = null;

        if(params.getFiles() == null){
        }else{
            files = fileUtils.uploadFiles(params.getFiles());
        }
        reviewService.savePost(params,files);

        return "redirect:/admin/review/list";
    }

    //이용후기 뷰 페이지
    @GetMapping("/view")
    public String openReviewDetail(@RequestParam final Long id, Model model){
        ReviewResponse items = reviewService.findPostById(id);
        model.addAttribute("items", items);
        return "admin/review/view";
    }

    //이용후기 수정
    @PostMapping("/update")
    public String updateReview(final ReviewRequest params){
        List<FileRequest> files = null;

        if(params.getFiles() == null){
            System.out.println(params);
        }else{
            files = fileUtils.uploadFiles(params.getFiles());
        }
        reviewService.updatePost(params,files);
        return "redirect:/admin/review/list";
    }

    //게시판 삭제
    @GetMapping("/delete")
    public String deleteReview(@RequestParam final Long id){
        reviewService.deletePost(id);
        return "redirect:/admin/review/list";
    }

}

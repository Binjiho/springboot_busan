package com.example.demo.admin.notice.controller;

import com.example.demo.admin.notice.NoticeRequest;
import com.example.demo.admin.notice.NoticeResponse;
import com.example.demo.admin.notice.service.NoticeService;
import com.example.demo.base.controller.BaseController;
import com.example.demo.base.file.FileRequest;
import com.example.demo.base.file.FileUtils;
import com.example.demo.base.paging.PagingResponse;
import com.example.demo.base.paging.SearchDto;

import com.example.demo.project.review.ReviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/notice")
@RequiredArgsConstructor
public class NoticeController extends BaseController {

    private final NoticeService noticeService;
    private final FileUtils fileUtils;

    /**
     * 공지사항 페이지
     * @return
     */
    @GetMapping("/list")
    public String openNoticeListPage(@ModelAttribute("params") final SearchDto params, Model model){
        PagingResponse<NoticeResponse> list = noticeService.findAllPost(params);
        model.addAttribute("list", list);
        return "admin/notice/list";
    }

    //공지사항 작성 페이지
    @GetMapping("/write")
    public String openNoticeWritePage(@RequestParam(value = "id", required = false) final Long id, Model model) {
        NoticeResponse items = null;
        if (id != null) {
            items = noticeService.findPostById(id);
        }
        model.addAttribute("items", items);
        return "admin/notice/write";
    }

    //공지사항 생성
    @PostMapping("/save")
    public String saveNotice(final NoticeRequest params) {
        noticeService.savePost(params);
        return "redirect:/admin/notice/list";
    }

    //공지사항 뷰 페이지
    @GetMapping("/view")
    public String openNoticeDetail(@RequestParam final Long id, Model model){
        NoticeResponse items = noticeService.findPostById(id);
        model.addAttribute("items", items);
        return "admin/notice/view";
    }

    //공지사항 수정
    @PostMapping("/update")
    public String updateNotice(final NoticeRequest params){
        noticeService.updatePost(params);
        return "redirect:/admin/notice/list";
    }

}

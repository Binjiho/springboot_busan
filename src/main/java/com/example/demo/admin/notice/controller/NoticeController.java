package com.example.demo.admin.notice.controller;

import com.example.demo.admin.notice.dto.NoticeDto;
import com.example.demo.admin.notice.service.NoticeService;
import com.example.demo.base.controller.BaseController;
import com.example.demo.base.paging.PageRequestDto;
import com.example.demo.base.paging.PageResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/notice")
@RequiredArgsConstructor
public class NoticeController extends BaseController {

    private final NoticeService noticeService;

    /**
     * 공지사항 페이지
     * @return
     */
    @GetMapping("/list")
    public String openAdminNoticeListPage(@ModelAttribute("params") final PageRequestDto pageRequestDto, Model model){
        PageResponseDto<NoticeDto> list = noticeService.getPageList(pageRequestDto);
        model.addAttribute("list", list);
        return "admin/notice/list";
    }

    @GetMapping("/write")
    public String openNoticeWritePage(@RequestParam(value = "id", required = false) final Long id, Model model) {
        NoticeDto items = null;
        if (id != null) {
            items = noticeService.findPostById(id);
        }
        model.addAttribute("items", items);
        return "admin/notice/write";
    }

    @PostMapping("/save")
    public String saveNotice(final NoticeDto noticeDto) {
        noticeService.savePost(noticeDto);
        return "redirect:/admin/notice/list";
    }

    @GetMapping("/detail/{id}")
    public String openNoticeDetail(@PathVariable("id") Long id, Model model){
        NoticeDto items = noticeService.findPostById(id);
        model.addAttribute("items", items);
        return "admin/notice/detail";
    }

    @PostMapping("/update")
    public String updateNotice(final NoticeDto noticeDto){
        noticeService.updatePost(noticeDto);
        return "redirect:/admin/notice/list";
    }

}

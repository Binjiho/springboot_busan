package com.example.demo.admin.notice.controller;

import com.example.demo.admin.notice.dto.NoticeDto;
import com.example.demo.admin.notice.service.NoticeService;
import com.example.demo.base.controller.BaseController;
import com.example.demo.base.file.FileRequest;
import com.example.demo.base.file.FileUtils;
import com.example.demo.base.paging.PageRequestDto;
import com.example.demo.base.paging.PageResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String openAdminNoticeListPage(@ModelAttribute("params") final PageRequestDto pageRequestDto, Model model){
        PageResponseDto<NoticeDto> list = noticeService.getPageList(pageRequestDto);
        model.addAttribute("list", list);
        return "admin/notice/list";
    }

    @GetMapping("/write")
    public String openNoticeWritePage(@RequestParam(value = "id", required = false) final Long id, Model model, NoticeDto noticeDto) {
        NoticeDto items = null;
        if (id != null) {
            items = noticeService.findPostById(id);
        }
        model.addAttribute("items", items);
        return "admin/notice/write";
    }

    @PostMapping("/save")
    public String saveNotice(@ModelAttribute NoticeDto noticeDto, Model model) {
        System.out.println(noticeDto);
        noticeService.savePost(noticeDto);
        return "redirect:/admin/notice/list";
    }
//
//    //공지사항 뷰 페이지
//    @GetMapping("/view")
//    public String openNoticeDetail(@RequestParam final Long id, Model model){
//        NoticeResponse items = noticeService.findPostById(id);
//        model.addAttribute("items", items);
//        return "admin/notice/view";
//    }
//
//    //공지사항 수정
//    @PostMapping("/update")
//    public String updateNotice(final NoticeRequest params){
//        noticeService.updatePost(params);
//        return "redirect:/admin/notice/list";
//    }

}

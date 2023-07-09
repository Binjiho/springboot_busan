package com.example.demo.project.review.controller;

import com.example.demo.admin.board.BoardDetailRequest;
import com.example.demo.admin.board.BoardDetailResponse;
import com.example.demo.admin.board.BoardRequest;
import com.example.demo.admin.board.BoardResponse;
import com.example.demo.admin.board.service.BoardDetailService;
import com.example.demo.admin.board.service.BoardService;
import com.example.demo.base.controller.BaseController;
import com.example.demo.base.dto.MessageDto;
import com.example.demo.base.file.FileRequest;
import com.example.demo.base.file.FileService;
import com.example.demo.base.file.FileUtils;
import com.example.demo.base.paging.PagingResponse;
import com.example.demo.base.paging.SearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController extends BaseController {

    private final BoardService boardService;
    private final BoardDetailService boardDetailService;
    private final FileService fileService;
    private final FileUtils fileUtils;

    /* review */
    /**
     * 이용후기 페이지
     * @return
     */
    @GetMapping("/list")
    public String openReviewListPage(){
        return "project/review/list";
    }

    //이용후기 작성 페이지
    @GetMapping("/review/write")
    public String openReviewdWritePage(@RequestParam(value = "id", required = false) final Long id, Model model) {
//        if (id != null) {
//            BoardResponse item = reviewService.findPostById(id);
//            model.addAttribute("item", item);
//        }
        return "project/review/write";
    }

    //이용후기 생성
//    @PostMapping("/review/save")
//    public String saveReview(final ReviewRequest params, Model model) {
//        reviewService.savePost(params);
//        return "redirect:/project/review/list";
//    }

    //이용후기 뷰 페이지
    @GetMapping("/detail")
    public String openReviewDetail(@RequestParam final Long id, Model model){
//        ReviewResponse item = reviewService.findPostById(id);
//        model.addAttribute("item", item);
        return "project/review/detail";
//        return "project/review/detail?id={id}";
    }

    //게시판 리스트 페이지
//    @GetMapping("/list")
//    public String openBoardList(@ModelAttribute("params") final SearchDto params, Model model){
//        PagingResponse<BoardResponse> boardList = boardService.findAllPost(params);
//        model.addAttribute("boardList", boardList);
//        return "admin/board/list";
//    }
//
//    //게시판 작성 페이지
//    @GetMapping("/write")
//    public String openboardWrite(@RequestParam(value = "id", required = false) final Long id, Model model) {
//        if (id != null) {
//            BoardResponse item = boardService.findPostById(id);
//            model.addAttribute("item", item);
//        }
//        return "admin/board/write";
//    }
//
//    //게시판 생성
//    @PostMapping("/save")
//    public String saveBoard(final BoardRequest params, Model model) {
//        boardService.savePost(params);
//        MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/admin/board/list", RequestMethod.GET, null);
//        return showAlertAndRedirect(message, model);
//    }
//
//    //게시판 뷰 페이지
//    @GetMapping("/view")
//    public String openBoardView(@RequestParam final Long id, Model model){
//        BoardResponse item = boardService.findPostById(id);
//        model.addAttribute("item", item);
//        return "admin/board/view";
//    }
//
//    //게시판 수정
//    @PostMapping("/update")
//    public String updateBoard(final BoardRequest params){
//        boardService.updatePost(params);
//        return "redirect:/admin/board/list";
//    }
//
//    //게시판 삭제
//    @PostMapping("/delete")
//    public String deleteBoard(@RequestParam final Long id){
//        boardService.deletePost(id);
//        return "redirect:/admin/board/list";
//    }

}

package com.example.demo.admin.board.controller;

import com.example.demo.admin.board.BoardDetailRequest;
import com.example.demo.admin.board.BoardDetailResponse;
import com.example.demo.admin.board.BoardRequest;
import com.example.demo.admin.board.service.BoardDetailService;
import com.example.demo.base.controller.BaseController;
import com.example.demo.base.file.FileRequest;
import com.example.demo.base.file.FileService;
import com.example.demo.base.file.FileUtils;
import com.example.demo.base.paging.PagingResponse;
import com.example.demo.base.paging.SearchDto;
import com.example.demo.admin.board.BoardResponse;
import com.example.demo.base.dto.MessageDto;
import com.example.demo.admin.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController extends BaseController {

    private final BoardService boardService;
    private final BoardDetailService boardDetailService;
    private final FileService fileService;
    private final FileUtils fileUtils;

    //게시판 리스트 페이지
    @GetMapping("/admin/board/list")
    public String openBoardList(@ModelAttribute("params") final SearchDto params, Model model){
        PagingResponse<BoardResponse> boardList = boardService.findAllPost(params);
        model.addAttribute("boardList", boardList);
        return "admin/board/list";
    }

    //게시판 작성 페이지
    @GetMapping("/admin/board/write")
    public String openboardWrite(@RequestParam(value = "id", required = false) final Long id, Model model) {
        if (id != null) {
            BoardResponse item = boardService.findPostById(id);
            model.addAttribute("item", item);
        }
        return "admin/board/write";
    }

    //게시판 생성
    @PostMapping("/admin/board/save")
    public String saveBoard(final BoardRequest params, Model model) {
        boardService.savePost(params);
        MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/admin/board/list", RequestMethod.GET, null);
        return showAlertAndRedirect(message, model);
    }

    //게시판 뷰 페이지
    @GetMapping("/admin/board/view")
    public String openBoardView(@RequestParam final Long id, Model model){
        BoardResponse item = boardService.findPostById(id);
        model.addAttribute("item", item);
        return "admin/board/view";
    }

    //게시판 수정
    @PostMapping("/admin/board/update")
    public String updateBoard(final BoardRequest params){
        boardService.updatePost(params);
        return "redirect:/admin/board/list";
    }

    //게시판 삭제
    @PostMapping("/admin/board/delete")
    public String deleteBoard(@RequestParam final Long id){
        boardService.deletePost(id);
        return "redirect:/admin/board/list";
    }

    //게시판 상세 뷰 페이지

    @GetMapping("/admin/board/detail/list")
    public String openDetailBoardList(@RequestParam final Long boardId, Model model){

        BoardResponse item = boardService.findPostById(boardId);
        model.addAttribute("item", item);

        List<BoardDetailResponse> boardDetailList = boardDetailService.findAllPostById(boardId);
        model.addAttribute("boardDetailList", boardDetailList);
        return "admin/board/detail/list";
    }

    //게시판 작성 페이지
    @GetMapping("/admin/board/detail/write")
    public String openDetailBoardWrite(@RequestParam(value = "id", required = false) final Long id, final Long boardId, Model model) {
        if (id != null) {
            BoardDetailResponse item = boardDetailService.findPostById(id);
            model.addAttribute("item", item);
        }
        model.addAttribute("boardId", boardId);
        return "admin/board/detail/write";
    }
    @PostMapping("/admin/board/detail/save")
    public String saveDetailBoard(final BoardDetailRequest params, RedirectAttributes redirectAttributes) {

        List<FileRequest> files = fileUtils.uploadFiles(params.getFiles());
        boardDetailService.savePost(params,files);

        redirectAttributes.addAttribute("boardId", params.getBoard_id());

        return "redirect:/admin/board/detail/list?boardId={boardId}";
//        MessageDto message = new MessageDto("상세 게시글 생성이 완료되었습니다.", "/admin/board/detail/list?boardId=${params.getBoard_id()}", RequestMethod.GET, null);
//        return showAlertAndRedirect(message, model);
    }

    @GetMapping("/admin/board/detail/view")
    public String openDetailBoardView(@RequestParam final Long id, Model model){
        BoardDetailResponse item = boardDetailService.findPostById(id);
        model.addAttribute("item", item);
        return "admin/board/detail/view";
    }

    //알럿 전달 후 페이지 리다이렉트
    private String showAlertAndRedirect(final MessageDto params, Model model){
        model.addAttribute("params", params);
        return "admin/common/alertRedirect";
    }
}

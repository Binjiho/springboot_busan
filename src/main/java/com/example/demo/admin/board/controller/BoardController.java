package com.example.demo.admin.board.controller;

import com.example.demo.admin.board.BoardRequest;
import com.example.demo.base.paging.PagingResponse;
import com.example.demo.base.paging.SearchDto;
import com.example.demo.admin.board.BoardResponse;
import com.example.demo.base.dto.MessageDto;
import com.example.demo.admin.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
//    private static final Logger LOGGER = LogManager.getLogger(BoardController.class);

    //게시글 작성 페이지
    @GetMapping("/admin/board/write.do")
    public String openboardWrite(@RequestParam(value = "id", required = false) final Long id, Model model) {
        if (id != null) {
            BoardResponse item = boardService.findPostById(id);
            model.addAttribute("item", item);
        }
        return "admin/board/write";
    }

    //게시글 생성
    @PostMapping("/admin/board/save.do")
    public String saveBoard(final BoardRequest params, Model model) {
        boardService.savePost(params);
        // return "redirect:/admin/board/list.do"; PRG패턴
        MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/admin/board/list.do", RequestMethod.GET, null);
        return showAlertAndRedirect(message, model);
    }

    //게시글 리스트 페이지
    @GetMapping("/admin/board/list.do")
    public String openBoardList(@ModelAttribute("params") final SearchDto params, Model model){
        PagingResponse<BoardResponse> boardList = boardService.findAllPost(params);
        model.addAttribute("boardList", boardList);
        return "admin/board/list";
    }

    //게시글 상세 페이지
    @GetMapping("/admin/board/view.do")
    public String openBoardView(@RequestParam final Long id, Model model){
        BoardResponse item = boardService.findPostById(id);
        model.addAttribute("item", item);
        return "admin/board/view";
    }

    //게시글 수정
    @PostMapping("/admin/board/update.do")
    public String updateBoard(final BoardRequest params){
        boardService.updatePost(params);
        return "redirect:/admin/board/list.do";
    }

    //게시글 삭제
    @PostMapping("/admin/board/delete.do")
    public String deleteBoard(@RequestParam final Long id){
        boardService.deletePost(id);
        return "redirect:/admin/board/list.do";
    }

    //알럿 전달 후 페이지 리다이렉트
    private String showAlertAndRedirect(final MessageDto params, Model model){
        model.addAttribute("params", params);
        return "admin/common/alertRedirect";
    }
}

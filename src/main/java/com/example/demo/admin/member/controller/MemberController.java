package com.example.demo.admin.member.controller;

import com.example.demo.admin.member.dto.MemberDto;

import com.example.demo.admin.member.service.MemberJoinService;
import com.example.demo.admin.member.service.MemberLoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
@Log4j2
public class MemberController {

    private final MemberJoinService memberJoinService;
    private final MemberLoginService memberLoginService;

    @GetMapping({"","/login/main"})
    public String openMainPage(){
        return "admin/main";
    }

    // 로그인 페이지
    @GetMapping("/member/login")
    public String openLoginPage() {
        return "admin/member/login";
    }

    //security에 의해 사용하지않음
//    @PostMapping("/member/login")
//    public String processLogin(@RequestBody final MemberDto memberDto){
//        boolean isValidMember = memberLoginService.isValidMember(memberDto.getUserId(), memberDto.getUserPw());
//        if (isValidMember)
//            return "/admin/main";
//        return "/admin/member/login";
//    }

    // 회원 정보 저장 (회원가입)
    @PostMapping("/member/save")
    @ResponseBody
    public Long saveMember(@RequestBody final MemberDto params) {
        return memberJoinService.memberInsert(params);
    }

    // 회원 수 카운팅 (ID 중복 체크)
    @PostMapping("/member/check")
    @ResponseBody
    public int countMemberByLoginId(@RequestBody final MemberDto params) {
        return memberJoinService.countMemberBysignUpId(params);
    }

    // 로그인
//    @PostMapping("/login")
//    @ResponseBody
//    public MemberResponse login(HttpServletRequest request) {
//
//        // 1. 회원 정보 조회
//        String loginId = request.getParameter("loginId");
//        String password = request.getParameter("password");
//        MemberResponse member = memberService.login(loginId, password);
//
//        // 2. 세션에 회원 정보 저장 & 세션 유지 시간 설정
//        if (member != null) {
//            HttpSession session = request.getSession();
//            session.setAttribute("loginMember", member);
//            session.setMaxInactiveInterval(60 * 30);
//        }
//
//        return member;
//    }

    // 로그아웃
//    @PostMapping("/logout")
//    public String logout(HttpSession session) {
//        session.invalidate();
//        return "redirect:/admin/login";
//    }
}
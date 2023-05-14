package com.app.session.controller;

import com.app.session.domain.MemberDTO;
import com.app.session.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @GetMapping("join")
    public String goToJoinForm(MemberDTO memberDTO){
        memberService.join(memberDTO);
    }
}

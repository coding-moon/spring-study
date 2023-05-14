package com.example.ex01.controller;

import com.example.ex01.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/ex/*") //선택 - 폴더이름
public class PracticeController {

    @Autowired
   /* MemberVO memberVO;*/

    @GetMapping("pr04")
    public void pr04(MemberVO memberVO) {
        log.info(memberVO.getName());
       /* log.info(memberVO.getAge());*/
        log.info(memberVO.getGender());
    }

}

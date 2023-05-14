package com.example.ex01.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserVO {
    //아이디 비밀번호
    private String userId;
    private String userPassword;
}

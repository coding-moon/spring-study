package com.example.ex01.controller;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Human {
    private String name;
    private Integer age;
    private String gender;
}

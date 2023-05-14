package com.example.ex04.service;

import com.example.ex04.aspect.annotation.LogStats;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;

@Service
@Slf4j
@LogStats
public class SampleService {
    public Integer doAdd(String str1, String str2) {
        log.info("핵심 로직");
        return parseInt(str1) + parseInt(str2);
    }
}

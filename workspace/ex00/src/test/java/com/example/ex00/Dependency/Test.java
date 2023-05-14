package com.example.ex00.Dependency;

import com.example.ex00.dependency.Chef;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class Test {

    @Autowired
    Chef chef;

    public void testChef() {
        log.info(String.valueOf(chef));
    }
}



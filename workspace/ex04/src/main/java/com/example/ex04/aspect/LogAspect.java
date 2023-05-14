package com.example.ex04.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Configuration
@Slf4j
public class LogAspect {

    @Before("@annotation(com.example.ex04.aspect.annotation.LogStats)")
    public void beforeStart(JoinPoint joinPoint) {
        log.info("join point" + joinPoint);
        log.info("proxy" + joinPoint.getThis());
        log.info("method" + joinPoint.getSignature().getName());
        log.info("arguments" + Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining())));
    }

    @After("@annotation(com.example.ex04.aspect.annotation.)
    public void afterEnd() {

    }

}

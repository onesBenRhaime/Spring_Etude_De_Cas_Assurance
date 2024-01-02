package com.example.revision.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExecutionTimeAspect {
    @Pointcut("execution(* com.example.revision.service..get*(..))")
    private void getMethods() {}

    @AfterReturning("getMethods()")
    public void afterGetMethods() {
        System.out.println("Bon courage !");
    }

}

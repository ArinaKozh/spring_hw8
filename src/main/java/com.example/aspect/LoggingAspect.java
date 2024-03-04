package com.example.aspect;

import java.util.Arrays;
import java.util.logging.Logger;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.example.model.User;

@Aspect
@Component
@Log
public class LoggingAspect {
    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @AfterReturning(value = "@annotation(TrackUserAction))", returning = "returnedValue")
    public void log(JoinPoint joinPoint, Object returnedValue) {
        // Получаем информацию о методе
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().toString();
        Object[] methodArgs = joinPoint.getArgs();
        System.out.println(methodName);
    }
}
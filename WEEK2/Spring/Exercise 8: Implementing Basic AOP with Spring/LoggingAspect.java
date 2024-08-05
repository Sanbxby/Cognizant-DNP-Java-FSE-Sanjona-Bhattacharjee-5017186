package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Advice that logs before method execution
    @Before("execution(* com.library.service.*.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        logger.info("Before method: " + joinPoint.getSignature().getName());
    }

    // Advice that logs after method execution
    @After("execution(* com.library.service.*.*(..))")
    public void logAfterMethod(JoinPoint joinPoint) {
        logger.info("After method: " + joinPoint.getSignature().getName());
    }
}

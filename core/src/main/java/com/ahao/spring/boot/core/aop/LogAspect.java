package com.ahao.spring.boot.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author ahao
 * @since 2019/6/23 16:21
 **/
@Aspect
@Component
public class LogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.ahao..*.ctrl..*.*(..))")
    public void webLog() {

    }

    @Before("webLog()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        LOGGER.info("URL is : {}", request.getRequestURL().toString());
        LOGGER.info("method is : {}.{}",
                joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        LOGGER.info("args[] is : {}", Arrays.toString(joinPoint.getArgs()));
        Long beginTime = System.currentTimeMillis();
        LOGGER.info("beginTime is : {}", beginTime);
        startTime.set(beginTime);
    }

    @After("webLog()")
    public void after() {
        Long endTime = System.currentTimeMillis();
        LOGGER.info("endTime is : {}", endTime);
        LOGGER.info("spend time is : {}", endTime - startTime.get());
    }

    @AfterReturning(pointcut = "webLog()", returning = "object")
    public void doReturn(Object object) {
        LOGGER.info("--**Result is : {}", object);
    }

    @Around(value = "webLog()")
    public Object doAround(ProceedingJoinPoint pjd) {
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        LOGGER.info("URL is : {}", request.getRequestURL().toString());
        LOGGER.info("method is : {}.{}",
                pjd.getSignature().getDeclaringTypeName(), pjd.getSignature().getName());
        LOGGER.info("args[] is : {}", Arrays.toString(pjd.getArgs()));
        Long beginTime = System.currentTimeMillis();
        LOGGER.info("beginTime is : {}", beginTime);
        startTime.set(beginTime);
        Object result = null;
        try {
            result = pjd.proceed(pjd.getArgs());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Long endTime = System.currentTimeMillis();
        LOGGER.info("endTime is : {}", endTime);
        LOGGER.info("spend time is : {}", endTime - startTime.get());
        LOGGER.info("--**result is : {}", result);
        return result;
    }
}

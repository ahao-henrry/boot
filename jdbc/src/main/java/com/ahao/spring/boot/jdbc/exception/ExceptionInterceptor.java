package com.ahao.spring.boot.jdbc.exception;

import com.ahao.spring.boot.jdbc.vo.ResultDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 25771
 * @since 2019/9/7 18:49
 **/
@RestControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(Exception e) {
        e.printStackTrace();
        return ResultDTO.error(e.getMessage());
    }
}

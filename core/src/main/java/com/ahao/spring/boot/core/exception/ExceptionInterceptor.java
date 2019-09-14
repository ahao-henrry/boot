package com.ahao.spring.boot.core.exception;

import com.ahao.spring.boot.core.vo.ResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ahao
 * @since 2019/7/16 8:45
 **/
@ControllerAdvice
public class ExceptionInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionInterceptor.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String exceptionHandler(Exception e) {
        LOGGER.info("--**catch exception : ", e);
        return ResultDTO.error(e.getMessage());
    }
}

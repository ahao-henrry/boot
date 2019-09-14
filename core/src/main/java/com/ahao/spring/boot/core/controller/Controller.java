package com.ahao.spring.boot.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Controller {
    private static final String DATETIME_FORMAT = "%tF %<tT";
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/time")
    public String getTime() {
        LOGGER.info("--**getTime...");
        return String.format(DATETIME_FORMAT, new Date());
    }
}

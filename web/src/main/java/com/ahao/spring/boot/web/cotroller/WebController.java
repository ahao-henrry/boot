package com.ahao.spring.boot.web.cotroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/web")
public class WebController {
    private static final String DATETIME_FORMAT = "%tF %<tT";
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/time")
    public String timePage(Map<String, Object> map) {
        map.put("time", String.format(DATETIME_FORMAT, new Date()));
        LOGGER.info("--**");
        return "time";
    }
}

package com.ahao.spring.boot.core.ctrl;

import com.ahao.spring.boot.core.service.ITimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ahao
 * @since 2019/7/15 21:36
 **/
@RestController
@RequestMapping("/time")
public class TimeCtrl {
    private static final Logger LOGGER = LoggerFactory.getLogger(TimeCtrl.class);
    @Autowired
    private ITimeService iTimeService;

    @GetMapping("/get")
    public String getComputer(String id, HttpServletRequest request) {
        LOGGER.info("--**{}", request.getRequestURL());
        LOGGER.info("--**para inner is : {}", id);
        return iTimeService.getProductionDate();
    }
}

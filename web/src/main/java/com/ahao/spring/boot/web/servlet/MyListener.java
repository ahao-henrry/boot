package com.ahao.spring.boot.web.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyListener.class);
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOGGER.info("--** listener initialized...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.info("--** listener destroyed...");
    }
}

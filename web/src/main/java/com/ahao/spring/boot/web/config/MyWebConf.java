package com.ahao.spring.boot.web.config;

import com.ahao.spring.boot.web.filter.I18nResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConf implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // registry.addViewController("/").setViewName("index");
        // registry.addViewController("/index.html").setViewName("index");
    }

    @Bean
    public WebMvcConfigurer loginWebMvcConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
            }
        };
        return webMvcConfigurer;
    }

    @Bean
    public LocaleResolver i18nResolver() {
        return new I18nResolver();
    }
}

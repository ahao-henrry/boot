package com.ahao.spring.boot.web.filter;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class I18nResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = request.getParameter("lang");
        if (StringUtils.isEmpty(lang)) {
            return Locale.getDefault();
        }
        String[] locale = lang.split("_");
        return new Locale(locale[0], locale[1]);
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}

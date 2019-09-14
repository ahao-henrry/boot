package com.ahao.spring.boot.core.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ahao
 * @since 2019/7/15 21:24
 **/
public class DateTimeTest {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 这里的时间格式必须要加T
        LocalDateTime dateTime = LocalDateTime.parse("2019-07-13T23:34:34");
        LocalDateTime now = LocalDateTime.now();
        String dateTimeNow = dateTime.format(dateTimeFormatter);
        System.out.println(dateTimeNow);


    }
}

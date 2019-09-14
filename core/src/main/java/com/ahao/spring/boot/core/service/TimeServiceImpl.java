package com.ahao.spring.boot.core.service;

import com.ahao.spring.boot.core.vo.ComputerVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author ahao
 * @since 2019/7/16 9:09
 **/
@Service
public class TimeServiceImpl implements ITimeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TimeServiceImpl.class);

    @Override
    public String getProductionDate() {
        ComputerVO computerVO = new ComputerVO();
        computerVO.setId(100);
        computerVO.setBrand("microsoft");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 这里的时间格式必须要加T
        LocalDateTime localDateTime = LocalDateTime.parse("2019-07-13T23:34:34");
        String dateTime = localDateTime.format(dateTimeFormatter);
        ZonedDateTime zonedDateTime = localDateTime.toLocalDate().atStartOfDay(ZoneId.of("America/Chicago"));
        computerVO.setProductionDate(Date.from(zonedDateTime.toInstant()));
        LOGGER.info("--**computer is : {}", computerVO);
        return dateTime;
    }
}

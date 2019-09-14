package com.ahao.spring.boot.core.auto;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author ahao
 * @since 2019/7/17 21:58
 **/
@Configuration
@Import(MyConfiguration.class)
public class MyAutoConfiguration {
}

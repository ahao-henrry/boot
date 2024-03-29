package com.ahao.spring.boot.core.test;

import com.ahao.spring.boot.core.conf.MyConf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CoreTest {
    @Autowired
    private MyConf myConf;

    @Test
    public void testCore() {
        System.out.println(myConf);
    }
}

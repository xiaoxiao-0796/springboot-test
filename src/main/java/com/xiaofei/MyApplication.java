package com.xiaofei;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaofei
 * Created at 2017/4/23.
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
@RestController
@Slf4j
public class MyApplication {


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testLogLevel() {
        log.debug("Logger Level ：DEBUG");
        log.info("Logger Level ：INFO");
        log.error("Logger Level ：ERROR");
        return "";
    }
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class,args);
    }
}

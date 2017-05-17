package com.xiaofei;

import com.xiaofei.stateMachine.enums.Events;
import com.xiaofei.stateMachine.enums.States;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.statemachine.StateMachine;
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
@EnableCaching
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

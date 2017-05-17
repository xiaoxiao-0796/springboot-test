package com.xiaofei;

import com.xiaofei.stateMachine.enums.Events;
import com.xiaofei.stateMachine.enums.States;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: xiao Date: 2017/5/17 0017 ProjectName: springboot-test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MachineTest implements CommandLineRunner {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @Test
    public void run() throws Exception {
         run("123");
    }

    @Override
    public void run(String... strings) throws Exception {
        stateMachine.start();
        stateMachine.sendEvent(Events.PAY);
//        stateMachine.sendEvent(Events.RECEIVE);
    }
}

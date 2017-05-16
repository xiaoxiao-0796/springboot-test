package com.xiaofei;

import com.xiaofei.mq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: xiao Date: 2017/5/16 0016 ProjectName: springboot-test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MqTest {

    @Autowired
    private Sender sender;

    @Test
    public void send(){
        sender.send();
    }

    @Test
    public void test1(){
        sender.sendMsg("nihahh");
    }

    @Test
    public void test2(){
        sender.send2("guangbo");
    }

}

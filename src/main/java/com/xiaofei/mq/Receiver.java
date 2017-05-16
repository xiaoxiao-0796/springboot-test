package com.xiaofei.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * MQ 消息消费者
 * <p>
 * 方法描述列表
 * </p>
 * User: xiao Date: 2017/5/16 0016 ProjectName: springboot-test
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {

    /**
     * 生产者-消费者
     * @param hello
     */
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver : " + hello);
    }

    /**
     * 路由器模式
     * @param str
     */
    @RabbitListener(queues="topic.message")    //监听器监听指定的Queue
    public void process1(String str) {
        System.out.println("message:"+str);
    }
    @RabbitListener(queues="topic.messages")    //监听器监听指定的Queue
    public void process2(String str) {
        System.out.println("messages:"+str);
    }


    /**
     * 广播模式
     * @param str1
     */
    @RabbitListener(queues="fanout.A")
    public void processA(String str1) {
        System.out.println("ReceiveA:"+str1);
    }
    @RabbitListener(queues="fanout.B")
    public void processB(String str) {
        System.out.println("ReceiveB:"+str);
    }
    @RabbitListener(queues="fanout.C")
    public void processC(String str) {
        System.out.println("ReceiveC:"+str);
    }
}

package com.xiaofei.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.support.postprocessor.ZipPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * MQ消息生产者
 * <p>
 * 方法描述列表
 * </p>
 * User: xiao Date: 2017/5/16 0016 ProjectName: springboot-test
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }

    /**
     * 路由器模式
     *
     * @param content
     */
    public void sendMsg(String content) {
        rabbitTemplate.convertAndSend("exchange", "topic.messages", content);
    }

    /**
     * 广播模式
     *
     * @param content
     */
    public void send2(String content) {
        rabbitTemplate.convertAndSend("fanoutExchange", "", content);
    }

}

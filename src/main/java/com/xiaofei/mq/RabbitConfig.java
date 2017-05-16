package com.xiaofei.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MQ Direct模式配置类 生产者-消费者
 * <p>
 * 方法描述列表
 * </p>
 * User: xiao Date: 2017/5/16 0016 ProjectName: springboot-test
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }
}

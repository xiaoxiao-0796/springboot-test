package com.xiaofei.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务
 *需要在主类上加入@EnableScheduling注解，启用定时任务的配置
 * <p>
 * 方法描述列表
 * </p>
 * User: xiao Date: 2017/4/26 0026 ProjectName: springboot-test
 */
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 每五秒执行一次
     */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}

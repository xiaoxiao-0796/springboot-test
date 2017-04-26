package com.xiaofei;

import com.xiaofei.async.AsyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: xiao Date: 2017/4/26 0026 ProjectName: springboot-test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AyscTaskTest {

    @Autowired
    AsyncTask asyncTask;

    @Test
    public void test1() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> task1 = asyncTask.taskone();
        Future<String> task2 = asyncTask.tasktwo();
        Future<String> task3 = asyncTask.taskthree();
        while(true) {
            if(task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }
}

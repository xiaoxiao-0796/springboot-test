package com.xiaofei.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * y异步方法，回调
 * 不回调可能导致的原因：
 * 1.没有任何任务相关的输出
 * 2.有部分任务相关的输出
 * 3.乱序的任务相关的输出
 *   原因是目前doTaskOne、doTaskTwo、doTaskThree三个函数的时候已经是异步执行了。
 *   主程序在异步调用之后，主程序并不会理会这三个函数是否执行完成了，
 *   由于没有其他需要执行的内容，所以程序就自动结束了，导致了不完整或是没有输出任务相关内容的情况。
 * <p>
 * 方法描述列表
 * </p>
 * User: xiao Date: 2017/4/26 0026 ProjectName: springboot-test
 */
@Component
public class AsyncTask {

    public static Random random =new Random();

    @Async
    public Future<String> taskone() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务一耗时："+(end-start));
        return new AsyncResult<>("任务一完成");
    }
    @Async
    public Future<String> tasktwo() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务二耗时："+(end-start));
        return new AsyncResult<>("任务二完成");
    }
    @Async
    public Future<String> taskthree() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务三耗时："+(end-start));
        return new AsyncResult<>("任务三完成");
    }
}

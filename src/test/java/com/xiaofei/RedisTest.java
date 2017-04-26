package com.xiaofei;

import com.xiaofei.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xiaofei
 * Created at 2017/4/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, User> redisTemplate;


    @Test
    public void test() throws Exception {
        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void test1() throws Exception {
        // 保存对象
        User user = new User("超人", "123");
        redisTemplate.opsForValue().set(user.getName(), user);
        user = new User("蝙蝠侠", "654");
        redisTemplate.opsForValue().set(user.getName(), user);
        user = new User("蜘蛛侠", "987");
        redisTemplate.opsForValue().set(user.getName(), user);
        Assert.assertEquals("123", redisTemplate.opsForValue().get("超人").getPasswd());
        Assert.assertEquals("654", redisTemplate.opsForValue().get("蝙蝠侠").getPasswd());
        Assert.assertEquals("987", redisTemplate.opsForValue().get("蜘蛛侠").getPasswd());
    }

}

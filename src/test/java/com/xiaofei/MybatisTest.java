package com.xiaofei;

import com.xiaofei.mapper.UserMapper;
import com.xiaofei.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Mybatis测试
 * <p>
 * 方法描述列表
 * </p>
 * User: xiao Date: 2017/4/26 0026 ProjectName: springboot-test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MybatisTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test1(){
        int insert = userMapper.insert("ha", "123456");
        User user = userMapper.findByName("ha");
        Assert.assertEquals(1,insert);
        Assert.assertEquals("123456",user.getPasswd());
    }

    @Test
    public void test2(){
        User user = userMapper.selectById(2);
        Assert.assertEquals("8109",user.getPasswd());
    }
}

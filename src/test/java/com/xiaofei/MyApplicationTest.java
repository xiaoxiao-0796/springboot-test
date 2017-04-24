package com.xiaofei;

import com.xiaofei.dal.UserRepository;
import com.xiaofei.model.User;
import com.xiaofei.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by xiaofei
 * Created at 2017/4/23.
 * //classes为springboot启动类
 * 单元测试记得把Swagger类上的@Configuration注解注释掉，不然报
 * No qualifying bean of type [org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping] found for dependency
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyApplication.class)
public class MyApplicationTest {

    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();
        user.setName("xaipo");
        user.setPasswd("8109");
        userService.create(user);
    }


    @Test
    public void query1(){
        List<User> user = userRepository.findByName("xaio");
        System.out.println("use="+user);
    }


}

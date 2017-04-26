package com.xiaofei;

import com.xiaofei.dal.UserRepository;
import com.xiaofei.model.User;
import com.xiaofei.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xiaofei
 * Created at 2017/4/23.
 * //classes为springboot启动类
 * 单元测试记得把Swagger类上的@Configuration注解注释掉，不然报
 * No qualifying bean of type [org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping] found for dependency
 *j
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MyApplicationTest {

    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
//    @Qualifier("primaryJdbcTemplate")
    JdbcTemplate primaryJdbcTemplate;

    @Test
    public void jdbc1(){
        List<User> users = primaryJdbcTemplate.query("select * from user", BeanPropertyRowMapper.newInstance(User.class));
        System.out.println(users);
    }

    @Test
    public void create(){
        User user = new User();
        user.setName("xa2o");
        user.setPasswd("8109");
        userService.create(user);
    }


    @Test
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void query1(){

        userRepository.save(new User("xiao111","xiao1"));
        userRepository.save(new User("xiao221","xaio2"));
        userRepository.save(new User("xiao444","xaio4"));
        List<User> user = userRepository.findByName("xaio");
        System.out.println("use="+user);
    }


}

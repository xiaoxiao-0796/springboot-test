package com.xiaofei.service.impl;

import com.xiaofei.model.User;
import com.xiaofei.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiaofei
 * Created at 2017/4/23.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    JdbcTemplate jdbcTemplate;

    @Override
    public void create(User user) {
        jdbcTemplate.update("INSERT INTO USER (name,passwd) VALUES (?,?)",
                user.getName(),user.getPasswd());
    }

    @Override
    public List<User> queryAll() {
        return jdbcTemplate.query("SELECT * FROM USER",BeanPropertyRowMapper.newInstance(User.class));
    }

    @Override
    public User queryById(Integer id) {
        RowMapper<User >
                rm = BeanPropertyRowMapper.newInstance(User .class);
        return jdbcTemplate.queryForObject("select * from user where id = ?",rm,id);
    }

    @Override
    public Integer updateByID(User user) {
        return jdbcTemplate.update("UPDATE USER SET NAME = ? ,passwd = ? WHERE id = ?",
                user.getName(),user.getPasswd(),user.getId());
    }

    @Override
    public Integer deleteById(Integer id) {
        return jdbcTemplate.update("delete from USER WHERE id = ?",id);
    }

    @Override
    public Integer deleteAll() {
        return jdbcTemplate.update("DELETE FROM USER ");
    }
}

package com.xiaofei.service;

import com.xiaofei.model.User;

import java.util.List;

/**
 * Created by xiaofei
 * Created at 2017/4/23.
 */
public interface UserService {


    void create(User user);

    List<User> queryAll();

    User queryById(Integer id);

    Integer updateByID(User user);

    Integer deleteById(Integer id);

    Integer deleteAll();
}

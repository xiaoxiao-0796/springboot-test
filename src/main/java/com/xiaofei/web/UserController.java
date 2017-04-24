package com.xiaofei.web;

import com.xiaofei.model.User;
import com.xiaofei.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xiaofei
 * Created at 2017/4/23.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "新增用户信息" ,notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user",value = "用户详细实体user",required = true,paramType = "User")
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody User user){
        userService.create(user);
        return "success";
    }

    @ApiOperation(value = "获取所有用户信息")
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @ResponseBody
    public List<User> queryAll(){
        List<User> users = userService.queryAll();
        return users;
    }

    @ApiOperation(value = "根据id获取用户信息",notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,paramType = "Integer",dataType = "path")
    @RequestMapping(value = "/query/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User queryById(@PathVariable(value = "id") Integer id){
        User user = userService.queryById(id);
        return user;
    }

    @ApiOperation(value = "更新用户信息",notes = "根据id更新用户信息")
    @ApiImplicitParam(name = "user",value = "用户详细实体user",required = true,paramType = "User")
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public Integer updateById(@RequestBody User user){
        Integer integer = userService.updateByID(user);
        return integer;
    }

    @ApiOperation(value = "删除单个用户信息",notes = "根据id删除用户信息")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,paramType = "Integer",dataType = "path")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteById(@PathVariable(value = "id") Integer id){
        Integer integer = userService.deleteById(id);
        return integer==1?"success":"failed";
    }

    @ApiOperation(value = "删除所有用户信息")
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(){
        userService.deleteAll();
        return "success";
    }
}

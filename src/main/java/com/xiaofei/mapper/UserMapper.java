package com.xiaofei.mapper;

import com.xiaofei.model.User;
import org.apache.ibatis.annotations.*;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: xiao Date: 2017/4/26 0026 ProjectName: springboot-test
 */
@Mapper
public interface UserMapper {

    @Select(value = "select * from user where name = #{name}")
    @Results({
            @Result(property = "id",column = "ID"),
            @Result(property = "name",column = "NAME"),
            @Result(property = "passwd",column = "PASSWD")
    })
    User findByName(@Param(value = "name") String name);

    @Insert(value = "insert into user(name,passwd) values (#{name},#{passwd})")
    int insert(@Param("name") String name,@Param("passwd") String passwd);

    User selectById(@Param("id") Integer id);
}

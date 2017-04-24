package com.xiaofei.dal;

import com.xiaofei.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xiaofei
 * Created at 2017/4/24.
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findByName(String name);
}

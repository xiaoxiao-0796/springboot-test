package com.xiaofei.dal;

import com.xiaofei.model.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 使用data-jpa
 * Created by xiaofei
 * Created at 2017/4/24.
 */
@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User,Integer> {

    @Cacheable(key = "#p0", condition = "#p0.length() < 10")
    List<User> findByName(String name);
}

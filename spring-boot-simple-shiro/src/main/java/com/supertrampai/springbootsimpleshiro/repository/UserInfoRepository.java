package com.supertrampai.springbootsimpleshiro.repository;

import com.supertrampai.springbootsimpleshiro.domain.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * @Description
 * @auther lxh800109@gmail.com
 * @create 2019-08-18 15:39
 */


public interface UserInfoRepository extends CrudRepository<UserInfo,Long> {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}

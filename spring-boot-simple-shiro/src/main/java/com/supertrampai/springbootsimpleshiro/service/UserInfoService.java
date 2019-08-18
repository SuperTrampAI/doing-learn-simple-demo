package com.supertrampai.springbootsimpleshiro.service;

import com.supertrampai.springbootsimpleshiro.domain.UserInfo;
import com.supertrampai.springbootsimpleshiro.repository.UserInfoRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/18 15:43
 */
@Service
public class UserInfoService {

    @Resource
    private UserInfoRepository userInfoRepository;

    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoService.findByUsername()");
        return userInfoRepository.findByUsername(username);
    }

}

package com.supertrampai.springbootsimplemongodb;

import com.supertrampai.springbootsimplemongodb.domain.User;
import com.supertrampai.springbootsimplemongodb.repository.UserRepository;
import com.supertrampai.springbootsimplemongodb.service.UserService;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/24 11:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSaveUser() throws Exception {
        User user=new User();
        user.setId(ObjectId.get());
        user.setName("name1");
        user.setPassword("123");
        user.setAge(12);
        user.setSex(1);
        user.setNickname("nickname1");
        user.setUsertype(1);
        user.setStatus(1);
        user.setCreatedt(new Date());
        userService.saveUser(user);
    }

    @Test
    public void findUserByUserName(){
        User user= userService.findUserByName("name1");
        System.out.println("user is "+user);
    }

    @Test
    public void updateUser(){
        User user=new User();
        user.setId(ObjectId.get());
        user.setName("天空");
        user.setPassword("fffxxxx");
        userService.updateUser(user);
    }

    @Test
    public void deleteUserById(){
        userService.deleteUserById(1);
    }

}

package com.supertrampai.springbootsimplemongodb.service;

import com.mongodb.client.result.UpdateResult;
import com.supertrampai.springbootsimplemongodb.domain.User;
import com.supertrampai.springbootsimplemongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/24 11:29
 */
@Service
@Component
public class UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     * @param user
     */
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    /**
     * 根据用户名查询对象
     * @param name
     * @return
     */
    public User findUserByName(String name) {
        Query query=new Query(Criteria.where("name").is(name));
        User user =  mongoTemplate.findOne(query , User.class);
        return user;
    }

    /**
     * 更新对象
     * @param user
     */
    public long updateUser(User user) {
        Query query=new Query(Criteria.where("id").is(user.getId()));
        Update update= new Update().set("name", user.getName()).set("password", user.getPassword());
        //更新查询返回结果集的第一条
        UpdateResult result =mongoTemplate.updateFirst(query,update,User.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
        if(result!=null) {
            return result.getMatchedCount();
        }
        else{
            return 0;
        }
    }

    /**
     * 删除对象
     * @param id
     */
    public void deleteUserById(Integer id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,User.class);
    }

}

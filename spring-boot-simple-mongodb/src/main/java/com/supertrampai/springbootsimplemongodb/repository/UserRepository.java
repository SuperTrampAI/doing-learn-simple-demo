package com.supertrampai.springbootsimplemongodb.repository;


import com.supertrampai.springbootsimplemongodb.domain.User;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
public interface UserRepository extends MongoRepository<User, Integer> {

    /**
     *
     * @param name
     * @return
     */
    public User findByName(String name);

    /**
     *
     * @param nickname
     * @return
     */
    public List<User> findByNickname(String nickname);

    User findById(ObjectId _id);


}

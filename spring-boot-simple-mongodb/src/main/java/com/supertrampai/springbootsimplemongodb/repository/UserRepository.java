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
     * TODO:如果代码中有该标识，说明在标识处有功能代码待编写，待实现的功能在说明中会简略说明。
     * FIXME：如果代码中有该标识，说明标识处代码需要修正，甚至代码是错误的，不能工作，需要修复，如何修正会在说明中简略说明。
     * SPAITODO:如果代码中有该标识，说明标识处代码虽然实现了功能，但是实现的方法有待商榷，希望将来能改进，要改进的地方会在说明中简略说明。
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

package com.supertrampai.springbootsimplewebfluxdemo.repository;

import com.supertrampai.springbootsimplewebfluxdemo.model.Tweet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 16:54 2019/8/30
 * @Modified By:
 */
@Repository
public interface TweetRepository extends ReactiveMongoRepository<Tweet, String> {

}
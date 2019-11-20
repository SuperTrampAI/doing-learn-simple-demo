package com.supertrampai.guavasimplelearn;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 17:17 2019/11/20
 * @Modified By:
 */
public class GuavaCacheDemo {

    public static void main(String[] args) {

        Cache<String,String> stringStringCache= CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterAccess(10, TimeUnit.MINUTES)
                .build();
        stringStringCache.put("word","Hello Guava Cache");
        System.out.println(stringStringCache.getIfPresent("word"));
    }

}

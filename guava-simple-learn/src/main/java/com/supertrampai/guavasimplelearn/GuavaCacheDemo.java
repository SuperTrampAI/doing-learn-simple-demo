package com.supertrampai.guavasimplelearn;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 17:17 2019/11/20
 * @Modified By:
 */
public class GuavaCacheDemo {

    public static void main(String[] args) throws InterruptedException {

        //创建cache的方式
        Cache<String,String> stringStringCache= CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterAccess(10, TimeUnit.MINUTES)
                .build();
        stringStringCache.put("word","Hello Guava Cache");
        System.out.println(stringStringCache.getIfPresent("word"));

        Cache<String,String> stringCache=createCache();
        stringCache.put("1","name1");
        stringCache.put("2","name2");
        stringCache.put("3","name3");

        System.out.println("第一个："+stringCache.getIfPresent("1"));//会把第一个删除，然后插入进第三个
        System.out.println("第er个："+stringCache.getIfPresent("2"));
        System.out.println("第san个："+stringCache.getIfPresent("3"));

        //设置过期时间
        //expireAfterWrite方法指定对象被写入到缓存后多久过期
        Cache<String,String> stringCache2=CacheBuilder.newBuilder()
                .maximumSize(2)
                .expireAfterWrite(3,TimeUnit.SECONDS)
                .build();

        stringCache2.put("1","v1");

        int time = 1;
        /*for(int i=1;i<=5;i++){
            System.out.println("第" + i + "次取到key1的值为：" + stringCache2.getIfPresent("1"));
            Thread.sleep(1000);
        }*/

        //expireAfterAccess指定对象多久没有被访问后过期。
        Cache<String,String> stringCache1=CacheBuilder.newBuilder()
                .maximumSize(2)
                .expireAfterWrite(3,TimeUnit.SECONDS)
                .build();

        stringCache1.put("1","vv1");
        /*for(int i=1;i<=5;i++){
            Thread.sleep(time*1000);
            System.out.println("第" + i + "次取到key1的值为：" + stringCache1.getIfPresent("1"));
        }*/

        //弱应用  weakKeys  weakValues
        Cache<String,Object> stringStringCache1 =CacheBuilder.newBuilder()
                .maximumSize(2)
                .weakValues()
                .build();
        PeopleNew peopleNew=new PeopleNew();
        peopleNew.setAge(12);
        peopleNew.setName("name123");
        stringStringCache1.put("one",peopleNew);
        peopleNew=new PeopleNew();
        System.gc();
        System.out.println("弱引用:"+stringStringCache1.getIfPresent("one"));

        // 显示清除  invalidateAll  invalidate:按照key清除
        Cache<String,String> stringCache3 =CacheBuilder.newBuilder().build();
        stringCache3.put("1","v1");
        stringCache3.put("2","v2");
        stringCache3.put("3","v3");

        List<String> stringList= Arrays.asList("1","2");
        stringCache3.invalidateAll(stringList);

        System.out.println("1清除后:"+stringCache3.getIfPresent("1"));
        System.out.println("2清除后:"+stringCache3.getIfPresent("2"));
        System.out.println("3清除后:"+stringCache3.getIfPresent("3"));


    }

    //1.创建Cacheloader
    public static CacheLoader<String,PeopleNew> createCacheLoader(){
        return new CacheLoader<String, PeopleNew>() {
            @Override
            public PeopleNew load(String s) throws Exception {
                return new PeopleNew(1,"name");
            }
        };
    }
    //2.创建cache
    public  static Cache<String,String> createCache(){
        return CacheBuilder.newBuilder()
                .maximumSize(2)//指定最大存放两个对象
                .build();
    }

}

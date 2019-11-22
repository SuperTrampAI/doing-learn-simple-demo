package com.supertrampai.guavasimplelearn;

import com.google.common.cache.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
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

        //removalListener删除监听事件
        RemovalListener<String,String> removalListener =new RemovalListener<String, String>() {
            @Override
            public void onRemoval(RemovalNotification<String, String> removalNotification) {
                System.out.println(removalNotification.getKey()+":"+removalNotification.getValue()+":已删除");
            }
        };

        // 显示清除  invalidateAll  invalidate:按照key清除
        Cache<String,String> stringCache3 =CacheBuilder.newBuilder()
                .removalListener(removalListener)
                .build();
        stringCache3.put("1","v1");
        stringCache3.put("2","v2");
        stringCache3.put("3","v3");



        List<String> stringList= Arrays.asList("1","2");
        stringCache3.invalidateAll(stringList);

        System.out.println("1清除后:"+stringCache3.getIfPresent("1"));
        System.out.println("2清除后:"+stringCache3.getIfPresent("2"));
        System.out.println("3清除后:"+stringCache3.getIfPresent("3"));

        // 获取key时,当key存在时,返回key对应的记录,如果key不存在,guava则会其他callable中的call方法,call方法的返回值,将被存贮在key中,并且被get返回.
        //如果多个线程访问一个同一个cache中的key,call方法只会加载一次
        Cache<String ,String> stringCache4 =CacheBuilder.newBuilder()
                .maximumSize(3)
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1");
                try {
                    String s = stringCache4.get("key", new Callable<String>() {
                        @Override
                        public String call() throws Exception {
                            System.out.println("load1");
                            return "线程一返回";
                        }
                    });
                    System.out.println(s);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread2");
                try {
                    String s = stringCache4.get("key", new Callable<String>() {
                        @Override
                        public String call() throws Exception {
                            System.out.println("load1");
                            return "线程二返回";
                        }
                    });
                    System.out.println(s);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 统计信息 recordStats
        Cache<String,String> stringCache5=CacheBuilder.newBuilder()
                .recordStats()
                .build();

        stringCache5.put("1","v1");
        stringCache5.put("2","v2");
        stringCache5.put("3","v3");

        stringCache5.getIfPresent("1");
        stringCache5.getIfPresent("2");
        stringCache5.getIfPresent("3");
        stringCache5.getIfPresent("4");
        stringCache5.getIfPresent("5");

        //打印状态
        System.out.println(stringCache5.stats());

        // 使用cacheloader
        LoadingCache<String,String> loadingCache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .build(stringCacheLoader());//在构建时指定自动加载器
        try {
            loadingCache.get("1");
            loadingCache.get("2");
            loadingCache.get("3");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    //1.创建Cacheloader 该接口是cache的子接口 区别在于,如果记录不存在,可以自动加载数据到缓存
    public static CacheLoader<String,PeopleNew> createCacheLoader(){
        return new CacheLoader<String, PeopleNew>() {
            @Override
            public PeopleNew load(String s) throws Exception {
                return new PeopleNew(1,"name");
            }
        };
    }
    public static  CacheLoader<String,String> stringCacheLoader(){
        CacheLoader<String,String> cacheLoader=new CacheLoader<String, String>() {
            @Override
            public String load(String s) throws Exception {
                System.out.println(s+" is loaded from a cacheloader");
                return s;
            }

        };
        return cacheLoader;
    }

    //2.创建cache
    public  static Cache<String,String> createCache(){
        return CacheBuilder.newBuilder()
                .maximumSize(2)//指定最大存放两个对象
                .build();
    }

}

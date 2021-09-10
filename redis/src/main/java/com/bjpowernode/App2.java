package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App2 {
    public static void main(String[] args) {
        JedisPool pool = null;
        try {
            pool = RedisUtils.open("192.168.72.128", 6379);
            Jedis jedis = pool.getResource();
            jedis.flushAll();
            Map map = new HashMap();
            map.put("name", "zhangsan");
            map.put("age", "34");
            map.put("sex", "男");
            jedis.hset("website", "taobao", "www.baidu.com");
            String website = jedis.hget("website", "taobao");
            System.out.println(website);
            jedis.hmset("student", map);
            List<String> list = jedis.hmget("student", "name", "age");
            for (String str : list) {
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RedisUtils.close();
        }
    }
}

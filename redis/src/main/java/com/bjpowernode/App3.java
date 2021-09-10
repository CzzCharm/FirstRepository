package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;

public class App3 {
    public static void main(String[] args) {
        JedisPool pool = null;
        try {
            pool = RedisUtils.open("192.168.72.128", 6379);
            Jedis jedis = pool.getResource();
            jedis.flushAll();
            Transaction transaction = jedis.multi();
            transaction.set("name", "zhangsan");
            transaction.set("age", "56");
            List<Object> exec = transaction.exec();
            for (Object o : exec) {
                System.out.println(o);
            }
            String s = jedis.get("name");
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RedisUtils.close();
        }
    }
}

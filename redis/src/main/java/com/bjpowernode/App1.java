package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class App1
{
    public static void main( String[] args )
    {
        JedisPool pool = null;
        try {
            pool = RedisUtils.open("192.168.72.128", 6379);
            Jedis jedis = pool.getResource();
            //清空数据
            jedis.flushAll();

            jedis.mset("age","12","kk","xx");
            List<String> list = jedis.mget("age", "kk");
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RedisUtils.close();
        }
    }
}

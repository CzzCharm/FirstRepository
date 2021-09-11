package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class App
{
    public static void main( String[] args )
    {
        JedisPool pool = null;
        //asdazxcxzasdasdasdasd
        try {
            pool = RedisUtils.open("192.168.72.128", 6379);
            Jedis jedis = pool.getResource();
            jedis.flushAll();
            jedis.set("name", "zhangsan");
            String s = jedis.get("name");
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RedisUtils.close();
        }

    }
}

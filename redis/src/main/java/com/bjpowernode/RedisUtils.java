package com.bjpowernode;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {
    //定义连接池对象
    private static JedisPool pool = null;

    //创建连接池
    public static JedisPool open(String host, int port) {
        if (pool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(10);
            config.setMaxIdle(3);
            config.setTestOnBorrow(true);
            pool = new JedisPool(config, host, port);
        }
        return pool;
    }

    //关闭连接池
    public static void close() {
        if (pool != null) {
            pool.close();
        }
    }
}

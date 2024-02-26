package org.gskeno.jedis.example;

import redis.clients.jedis.JedisPooled;

/**
 * 单服务器 简单使用
 */
public class SimpleUse {
    public static void main(String[] args) {
        useJedisPooled();
    }

    public static void useJedisPooled(){
        JedisPooled jedis = new JedisPooled("localhost", 6379);
        // 集合命令
        jedis.sadd("planets", "Venus");
    }
}

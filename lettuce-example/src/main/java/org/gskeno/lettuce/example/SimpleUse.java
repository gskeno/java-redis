package org.gskeno.lettuce.example;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisStringCommands;

public class SimpleUse {
    public static void main(String[] args) {
        basicUse();
    }

    public static void basicUse(){
        RedisClient client = RedisClient.create("redis://localhost");
        StatefulRedisConnection<String, String> connection = client.connect();
        RedisStringCommands sync = connection.sync();
        Object o = sync.get("g");
        System.out.println(o);
    }
}

package com.gskeno.redission.example;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

import java.io.IOException;

public class QuickStart {
    public static void main(String[] args) throws IOException {
        // 1. Create config object
        Config config = new Config();
        config.useClusterServers()
                // use "rediss://" for SSL connection
                .addNodeAddress("redis://127.0.0.1:7181");

        // or read config from file
        // config = Config.fromYAML(new File("config-file.yaml"));


        // 2. Create Redisson instance

        // Sync and Async API
                RedissonClient redisson = Redisson.create(config);

        // Reactive API
                RedissonReactiveClient redissonReactive = redisson.reactive();

        // RxJava3 API
                RedissonRxClient redissonRx = redisson.rxJava();


        // 3. Get Redis based implementation of java.util.concurrent.ConcurrentMap
        RMap<Object, Object> myMap = redisson.getMap("myMap");

        RMapReactive<Object, Object> mapReactive = redissonReactive.getMap("myMap");

        RMapRx<Object, Object> mapRx = redissonRx.getMap("myMap");


        // 4. Get Redis based implementation of java.util.concurrent.locks.Lock
        RLock lock = redisson.getLock("myLock");

        RLockReactive lockReactive = redissonReactive.getLock("myLock");

        RLockRx lockRx = redissonRx.getLock("myLock");

        // 4. Get Redis based implementation of java.util.concurrent.ExecutorService
        RExecutorService executor = redisson.getExecutorService("myExecutorService");

        // over 50 Redis based Java objects and services ...

    }
}

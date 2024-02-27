package org.gskeno.lettuce.example;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisStringAsyncCommands;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

/**
 * 异步api
 */
public class AsynchronousUsage {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RedisClient client = RedisClient.create("redis://localhost");
        StatefulRedisConnection<String, String> connection = client.connect();
        RedisStringAsyncCommands<String, String> async = connection.async();
        RedisFuture<String> set = async.set("key", "value");
        RedisFuture<String> get = async.get("key");

        // 当前线程会阻塞
//        if (LettuceFutures.awaitAll(Duration.ofSeconds(2), set, get)){
//            System.out.println(set.get());
//            System.out.println(get.get());
//        }
        System.out.println("主线程是" + Thread.currentThread().getName());
        get.thenAccept(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
                // 可能是 lettuce-nioEventLoop-4-1 线程(异步)，也可能是main线程
                System.out.println("accept线程是:" + Thread.currentThread().getName());
            }
        });
    }
}

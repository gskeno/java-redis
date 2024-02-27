package org.gskeno.jedis.example;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

public class ClusterUsage {
    public static void main(String[] args) {
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6380));
        // jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6381));
        JedisCluster jedis = new JedisCluster(jedisClusterNodes);

        jedis.sadd("planets", "Mars");

        Set<String> planets = jedis.smembers("planets");
        System.out.println(planets);
    }
}

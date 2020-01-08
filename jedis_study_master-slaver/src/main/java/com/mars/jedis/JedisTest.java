package com.mars.jedis;

import redis.clients.jedis.Jedis;

public class JedisTest {
	
	public static void main(String[] args) {
		Jedis jedisMaster = new Jedis("192.168.233.128",6379);
		Jedis jedisSlaver = new Jedis("192.168.233.128",6380);
		jedisSlaver.slaveof("192.168.233.128",6379); // 设置从机
		jedisMaster.set("k1", "v189797979");
		System.out.println(jedisSlaver.get("k1"));
	}
}

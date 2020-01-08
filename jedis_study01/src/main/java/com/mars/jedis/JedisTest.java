package com.mars.jedis;

import java.util.Set;

import redis.clients.jedis.Jedis;

public class JedisTest {
	
	public static void main(String[] args) {
		// 高频热点数据放入redis中
		Jedis jedis = new Jedis("192.168.233.128",6379);
		long start = System.currentTimeMillis();
//		for(int i = 0; i < 100; i++) {
//			jedis.set("k" + i, "v" + i);
//		}
		
		System.out.println(jedis.get("k99"));
		Set<String> keys = jedis.keys("*");
		for(String str : keys) {
			System.out.println(str);
		}
		System.out.println(keys.size());
		long end = System.currentTimeMillis();
		System.out.println("总执行时间" + (end-start));
	}
}

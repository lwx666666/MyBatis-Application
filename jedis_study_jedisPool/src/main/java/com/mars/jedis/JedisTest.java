package com.mars.jedis;

import com.mars.jedis.util.JedisPoolUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {
	
	public static void main(String[] args) {
		JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			System.out.println(jedis.ping());
			jedis.set("testPool", "pong");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JedisPoolUtil.releaseJedisPool(jedisPool, jedis);
		}
	}
}

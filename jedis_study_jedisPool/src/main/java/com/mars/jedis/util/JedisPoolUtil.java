package com.mars.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {
	private static volatile JedisPool jedisPool = null;
	
	private JedisPoolUtil() {}
	
	/**
	 * 获取连接池实例
	 * @return JedisPool 连接池
	 */
	public static JedisPool getJedisPoolInstance() {
		// 双端检锁机制
		if(null == jedisPool) {
			
			synchronized(JedisPoolUtil.class){
				
				if(null == jedisPool) {
					JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
					jedisPoolConfig.setMaxActive(1000);// 设置池中最大连接数
					jedisPoolConfig.setMaxIdle(32); // 设置最大空闲实例数量，如果达到临界点则抛异常
					jedisPoolConfig.setMaxWait(100 * 1000); // 设置最大超时时间
					jedisPoolConfig.setTestOnBorrow(true); // 设置获取的连接必须是可用的，能ping通的
					jedisPool = new JedisPool(jedisPoolConfig,"192.168.233.128",6379);
				}
			}
		}
		return jedisPool;
	}
	
	/**
	 * 释放资源
	 * @param jedisPool
	 * @param jedis
	 */
	public static void releaseJedisPool(JedisPool jedisPool, Jedis jedis) {
		if(null != jedisPool) {
			jedisPool.returnResource(jedis); // 回收jedis连接
		}
	}
}

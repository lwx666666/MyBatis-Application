package com.mars.jedis;

import java.util.List;
import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.Jedis;

public class JedisTest {
	
	public static void main(String[] args) {
		// 一般将高频热点数据放入redis中
		Jedis jedis = new Jedis("192.168.233.128",6379);
		long start = System.currentTimeMillis();
		testList(jedis);
		long end = System.currentTimeMillis();
		System.out.println("总执行时间" + (end-start));
	}
	
	public static void print(Object obj) {
		System.out.println(obj);
	}
	/**
	 * list命令
	 * @param jedis
	 */
	public static void testList(Jedis jedis) {
		//jedis.lpush("list01", "1","2","3","4"); // 向链表中左存入
		//jedis.rpush("list02", "1","2","3","4"); // 向链表中右存入
		//jedis.lpush("list01", "5","6");
//		List<String> list01 = jedis.lrange("list01", 0, 4); // 遍历链表
//		for(String val : list01) {
//			System.out.println(val);
//		}
//		List<String> list02 = jedis.lrange("list02", 0, -1);
//		for(String val : list02) {
//			System.out.println(val);
//		}
//		print(jedis.lpop("list01")); // 从顶部弹出
//		print(jedis.rpop("list02")); // 从底部弹出
//		print(jedis.lindex("list02", 2)); // 指定索引取值
		//jedis.rpush("list02", "4","3","5","3","4");
		//print(jedis.lrem("list02", 3, "3")); // 删除三个三
//		jedis.ltrim("list02", 0, 5); // 从指定索引截取到结束索引
//		jedis.lrem("list02", 3, "4"); // 删除重复数据
//		jedis.rpoplpush("list01", "list02"); // 将源列表中最后一个值给目标列表
//		jedis.lset("list02", 2, "6"); // 替换指定索引的值
		//jedis.linsert("list01", BinaryClient.LIST_POSITION.BEFORE, "8", "9"); // 在8之前插入9
		jedis.linsert("list02", BinaryClient.LIST_POSITION.AFTER, "2", "7");
		List<String> list02 = jedis.lrange("list02", 0, -1);
		for(String val : list02) {
			print(val);
		}
		print("-----------------------------------------------");
		List<String> list01 = jedis.lrange("list01", 0, -1); // 遍历链表
		for(String val : list01) {
			print(val);
		}
	}
	/**
	 * string命令
	 * @param jedis
	 */
	public static void testStr(Jedis jedis) {
//		jedis.set("k1", "v101abc");
//		jedis.set("k2", "v2");
		//jedis.set("k3", "100");
//		jedis.set("k4", "hello redis");
		//jedis.select(0); // 选择三号数据库
		// key命令操作
		//jedis.move("k1", 3); // 将k1移动到3号数据库
		//jedis.expire("k1", 30); // 设置key的过期时间
//		Set<String> keys = jedis.keys("*");
//		System.out.println(keys.size());
		//jedis.del("k1");
//		Boolean existsKey = jedis.exists("k1");
//		System.out.println(existsKey);
//		System.out.println(jedis.ttl("k1"));
//		System.out.println(jedis.type("k2"));
		//jedis.append("k2", "fafafa"); // k2对应的值拼接字符串
//		System.out.println(jedis.get("k2"));
//		System.out.println(jedis.strlen("k2"));// 查询k2值的长度
//		System.out.println(jedis.incr("k3")); // 值自增1
		//System.out.println(jedis.incrBy("k3", 10)); // 自定义自增长度
//		print(jedis.decr("k3"));
//		print(jedis.decrBy("k3", 11));
		//System.out.println(jedis.getrange("k4", 1, 3)); // 截取key对应的字符串
//		print(jedis.setrange("k4", 5, " world")); // 替换字符换
//		print(jedis.get("k4"));
		//jedis.setex("k1", 30, "v101abc"); // 给字符串值设置过期时间
//		print(jedis.ttl("k1"));
//		print(jedis.setnx("k2", "this is k2 value")); // 如果没有则添加值
//		print(jedis.get("k2"));
//		jedis.mset("k5","v5","k6","v6"); // 一次设置多个值
//		print(jedis.mget("k5","k6")); //一次获取多个值
//		jedis.msetnx("k1","v1"); // 一次设置多个值，如果key不存在，如果其中有一个key是存在的则都保存不成功
//		print(jedis.mget("k1","k2","k3"));
	}
}

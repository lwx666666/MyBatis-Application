package com.mars.jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

public class JedisTest {
	
	public static void main(String[] args) {
		// 一般将高频热点数据放入redis中
		Jedis jedis = new Jedis("192.168.233.128",6379);
		long start = System.currentTimeMillis();
		zsetTest(jedis);
		long end = System.currentTimeMillis();
		System.out.println("总执行时间" + (end-start));
	}
	
	public static void print(String str) {
		System.out.println(str);
	}
	
	/**
	 * 
	 * @param jedis
	 */
	public static void zsetTest(Jedis jedis) {
		// jedis.zadd("zset01", 89,"3"); // 集合中添加一对数据
		//jedis.zadd("zset01", 95.8,"2");
//		jedis.zadd("zset01", 100,"1");
//		Map<Double,String> map = new HashMap<Double,String>();
//		map.put(80.0, "5");
//		map.put(72.0, "7");
//		map.put(65.5, "10");
//		jedis.zadd("zset01", map);
//		Set<String> vals = jedis.zrange("zset01", 0, -1); // 遍历zset中所有的元素
//		Set<Tuple> numWithScore = jedis.zrevrangeWithScores("zset01", 0, -1);// 遍历zset集合带分数
//		Iterator<String> iter = vals.iterator();
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
//		Iterator<Tuple> tuples = numWithScore.iterator();
//		while(tuples.hasNext()) {
//			Tuple t = tuples.next();
//			System.out.print(t.getElement() + "--");
//			System.out.println(t.getScore());
//		}
		
		//Set<String> vals2 = jedis.zrangeByScore("zset01", 70, 85);
		// Set<String> vals3 = jedis.zrangeByScore("zset01", "(65.5", "88");
		//Set<Tuple> numWithScores = jedis.zrangeByScoreWithScores("zset01",  "65.5", "(89");
//		int pageSize = 4;
//		int page = 2;
//		int offset = (page - 1) * 3;
//		// 分页查询
//		Set<Tuple> numWithScores2 = jedis.zrangeByScoreWithScores("zset01", "65.5", "100", offset, pageSize);
//		Iterator<String> iter = vals3.iterator();
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		
//		Iterator<Tuple> tuples = numWithScores2.iterator();
//		while(tuples.hasNext()) {
//			Tuple t = tuples.next();
//			System.out.print(t.getElement() + "--");
//			System.out.println(t.getScore());
//		}
		
//		jedis.zrem("zset01", "2");
//		Set<Tuple> tuples = jedis.zrangeWithScores("zset01",0, -1);
//		for(Tuple t : tuples) {
//			System.out.println(t.getScore());
//			System.out.println(t.getElement());
//		}
		long num = jedis.zcard("zset01"); // 统计集合元素个数
		System.out.println(num);
		long lev = jedis.zrank("zset01", "10"); // 获取当前元素的分数排名，从小到大排
		System.out.println(lev);
		double score = jedis.zscore("zset01", "10");
		System.out.println(score);
		long hot = jedis.zrevrank("zset01", "10");
		print(String.valueOf(hot));
		Set<String> vals = jedis.zrevrange("zset01", 0, -1); // 反向遍历
		for(String s : vals) {
			System.out.println(s);
		}
		Set<Tuple> tuples = jedis.zrevrangeByScoreWithScores("zset01", 100, 50); // 按照分值反向遍历
		for(Tuple t : tuples) {
			System.out.println(t.getScore() + "--" + t.getElement());
		}
	}
	
	/**
	 * map命令
	 * @param jedis
	 */
	public static void hashTest(Jedis jedis) {
//		jedis.hset("user", "name", "richard");
		String name = jedis.hget("user", "name"); // 获取单个字段
		print(name);
		jedis.hset("user", "id", "3");
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("id", "1");
//		map.put("age", "30");
//		map.put("email", "txt@111.com");
//		jedis.hmset("user",map);
//		List<String> list = jedis.hmget("user", "id","name","age","email"); // 获取多个指定字段
//		print(list.toString());
//		jedis.hdel("user", "email","age"); // 删除一个或多个字段
//		Map<String,String> map = jedis.hgetAll("user"); // 获取全部字段
//		Set<Map.Entry<String, String>> sets = map.entrySet();
//		Iterator<Map.Entry<String, String>> iter = sets.iterator();
//		while(iter.hasNext()) {
//			Map.Entry<String,String> ent = iter.next();
//			print(ent.getKey());
//			print(ent.getValue());
//		}
//		jedis.hset("user", "age", "20");
		jedis.hsetnx("user", "height", "170.22"); // 如果字段不存在则增加
		print(jedis.hlen("user").toString()); // 查看集合长度
		print(jedis.hexists("user", "email").toString()); // 查看集合是否存在
		print(jedis.hkeys("user").toString()); // 获取所有key
		print(jedis.hvals("user").toString()); // 获取所有value
		print(jedis.hincrBy("user", "age", 5).toString());
		print(jedis.hgetAll("user").toString());
	}
	
	/**
	 * set命令
	 * @param jedis
	 */
	public static void setTest(Jedis jedis) {
		//jedis.sadd("set01", "v1","v2","v3","v3","v2"); // 向set集合中添加元素，去重复
		
//		boolean m = jedis.sismember("set01", "v3"); // 是否集合元素
//		if(m) print("是set集合元素");
//		print(jedis.scard("set01")); // 查看集合元素个数
//		jedis.srem("set01", "v3"); // 删除集合元素

//		jedis.sadd("set02", "1","2","3","4","5","6","7","8");
//		print(jedis.srandmember("set02")); // 随机获取集合中的一个元素
//		print(jedis.spop("set02"));
		//jedis.smove("set02", "set01", "3"); // 将7移动到set01
//		Set<String> strs1 = jedis.sinter("set01","set02"); // 取集合交集
//		Set<String> strs1 = jedis.sdiff("set01","set02"); // 取差集
		Set<String> strs1 = jedis.sunion("set01","set02");//取并集，消除重复
//		Set<String> strs1 = jedis.smembers("set01");
		Iterator<String> iter1 = strs1.iterator();
		while(iter1.hasNext()) {
			print(iter1.next());
		}
		System.out.println("--------------------------------------------");
//		Set<String> strs2 = jedis.smembers("set02");
//		Iterator<String> iter2 = strs2.iterator();
//		while(iter2.hasNext()) {
//			print(iter2.next());
//		}
//		
		
	}
	/**
	 * list命令
	 * @param jedis
	 */
	public static void listTest(Jedis jedis) {
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
	public static void strTest(Jedis jedis) {
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

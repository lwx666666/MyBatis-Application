package com.mars.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;
/**
 * redis的事务模拟操作
 * @author libo
 *
 */
public class RedisTransationTest {
	
	public static boolean simulateTx(Jedis jedis) {
		
		jedis.set("balance", "100");
		jedis.set("debt", "0");
		
		jedis.watch("balance"); // 监视balance，如果balance被修改则执行事务失败
		
		// 开启一条线程修改blance
		new Thread() {
			@Override
			public void run() {
				Jedis jedis = new Jedis("192.168.233.128",6379);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				jedis.set("balance", "10");
			}
		}.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 如果数据被人修改则取消监视，并放弃事务操作
		if(Integer.parseInt(jedis.get("balance")) <= 10) {
			System.out.println("账户余额是：" + jedis.get("balance"));
			System.out.println("欠款是：" + jedis.get("debt"));
			System.out.println("数据以被修改，需要放弃事务");
			jedis.unwatch();
			return false;
		}
		Transaction tx = jedis.multi(); // 开启事务
		tx.decrBy("balance", 10);
		tx.incrBy("debt", 10);
		
		tx.exec();
		System.out.println("账户余额是：" + jedis.get("balance"));
		System.out.println("欠款是：" + jedis.get("debt"));
		return true;
	}
	
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.233.128",6379);
//		Transaction tx = jedis.multi();
//		tx.set("balance", "100");
//		tx.set("debt", "0");
//		tx.decrBy("balance", 10);
//		tx.incrBy("debt", 10);
//		tx.discard();
		//tx.exec();
		boolean r = simulateTx(jedis);
		if(r)
			System.out.println("事务执行成功");
		else
			System.out.println("事务执行失败");
	}
}

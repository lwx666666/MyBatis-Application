package designPattern.creator.singleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class PerformenceTest {
	static AtomicInteger c = new AtomicInteger(10);
	public static void main(String[] args) throws InterruptedException {
		int threadCount = 10;
//		CountDownLatch count = new CountDownLatch(threadCount);
		long start = System.currentTimeMillis();
		for(int k = 0; k < threadCount; k++) {
			Thread t = new Thread(()->{
				for(int i = 0; i < 10000; i++) {
					Singleton s = Singleton.getInstance();
				}
//				count.countDown();
				c.decrementAndGet();
			});
			t.start();
			t.join();
		}
		if(c.get() == 0) {
			System.out.println("gg");
		}
//		count.await();
		long end = System.currentTimeMillis();
		System.out.println("总用时：" + (end - start));
		
	}
}

package designPattern.creator.singleton;

/**
 * 单例模式
 * 1.饥汉式
 * 2.懒汉式
 * @author libo
 *
 */
public class SingletonModel {
	public static void main(String[] args) throws Exception {
		
		Runnable r = new Runnable() {

			@Override
			public void run() {
				try {
					
					synchronized(this){
						//Thread.sleep(100);
						//Singleton s = Singleton.getSingleton();
						//System.out.println(s);
						
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		
		for(int i = 0; i < 1000; i++) {
			Thread t1 = new Thread(r);
			t1.start();
			
		}
	
		
		// 通过反射获取单例实例
		// 获取类中的构造
		//Constructor c = Singleton.class.getDeclaredConstructor();
		// 设置构造访问可见
//		c.setAccessible(true);
//		Singleton s2 = (Singleton)c.newInstance();
//		System.out.println(s2);
	}
}

//class Singleton{
//	// 饥汉式
////	private static Singleton s = new Singleton();
//	private static Singleton s;
//	// 构造必须私有化
//	private Singleton() {}
//	public static synchronized Singleton getSingleton() {
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// 懒汉式
//		if(s == null)
//			s = new Singleton();
//		return s;
//	}
//}

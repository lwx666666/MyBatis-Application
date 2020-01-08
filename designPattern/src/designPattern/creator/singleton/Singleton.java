package designPattern.creator.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton implements Serializable{
	
	private static final long serialVersionUID = 1665227440558970182L;
	private static volatile Singleton instance = null;
	
	/**
	 * 构造私有化
	 */
	private Singleton() {
		// 放置返射破坏单例
		if(null != instance) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 双检锁
	 * @return
	 */
	public static Singleton getInstance() {
		
		if(null == instance) {
			synchronized(Singleton.class) {
				
				if(null == instance)
					instance = new Singleton();
			}
		}
		return instance;
	}
	/**
	 * 防范反序列化，破坏单例，使用此方法，反序列化时直接使用指定的对象，而不需要再创建对象
	 * @return
	 * @throws ObjectStreamException
	 */
	private Object readResolve() throws ObjectStreamException{
		return instance;
	}
}

package designPattern.creator.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class SingletonPerfectDemo {
	
	public static void main(String[] args) throws Exception {
//		Singleton s1 = Singleton.getInstance();
//		System.out.println(s1);
//		Singleton s2 = Singleton.getInstance();
//		System.out.println(s2);
		// 通过反射破坏单例
//		Class<Singleton> singletonClass = (Class<Singleton>) Class.forName("designPattern.Singleton");
//		Constructor<Singleton> cst = singletonClass.getDeclaredConstructor();
//		cst.setAccessible(true);
//		Singleton s = cst.newInstance();
//		System.out.println(s);
		// 通过反序列化破坏单例
//		FileOutputStream fos = new FileOutputStream("f:/io/obj.txt");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(s1);
//		oos.close();
//		fos.close();
//		
//		FileInputStream fis = new FileInputStream("f:\\io\\obj.txt");
//		ObjectInputStream ois = new ObjectInputStream(fis);
//		Singleton s3 = (Singleton) ois.readObject();
//		System.out.println(s3);
//		ois.close();
//		fis.close();
		B a = new B("123");
		a.a();
		
		
	}
	
	public static void test(A a) {
		a = new A("234");
	}
}

class A{
	private String name;
	private int num = 100;
	public A(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void a() {
		
	}
	public void b() {
		System.out.println(this.num);
	}
}

class B extends A{
	public B(String name) {
		super(name);
		
	}
	private int num = 10;
	public void a() {
		b();
	}
	
}

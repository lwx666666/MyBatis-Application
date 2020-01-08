package designPattern.structure.adapter;
/**
 * 结构型模式
 * 从程序结构上实现松耦合，从而扩大整体的类结构
 * 分类：适配器，代理，桥接，组合，装饰，外观，享元
 * 适配器模式：
 * 		经常用于旧系统的改造和升级
 * @author libo
 *
 */
public class AdapterDemo01 {
	
	public static void test(Target target) {
		target.handleReq();
	}
	// 客户端
	public static void main(String[] args) {
		Adaptee adaptee = new Adaptee();
		test(new Adapter2(adaptee));
	}
}

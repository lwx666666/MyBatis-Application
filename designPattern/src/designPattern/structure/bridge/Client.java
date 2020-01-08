package designPattern.structure.bridge;

/**
 * 桥接模式
 * 使用接口将两个关联维度分割开来
 * 作用：取代多重继承
 * @author libo
 *
 */
public class Client {
	public static void main(String[] args) {
		Brand b = new Lenovo();
		Computer c = new Desktop(b);
		c.sale();
		Computer c2 = new Pad(b);
		c2.sale();
	}
}

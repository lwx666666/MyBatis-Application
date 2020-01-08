package designPattern.structure.adapter;

/**
 * 适配器(组合模式)
 * @author libo
 *
 */
public class Adapter2 implements Target{
	private Adaptee adaptee = null;
	
	
	@Override
	public void handleReq() {
		adaptee.getReps();
	}
	public Adapter2(Adaptee adaptee) {
		this.adaptee = adaptee;
	}
}

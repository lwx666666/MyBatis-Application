package designPattern.structure.adapter;

/**
 * 适配器(类适配器方式)
 * @author libo
 *
 */
public class Adapter extends Adaptee implements Target{

	@Override
	public void handleReq() {
		super.getReps();
	}

}

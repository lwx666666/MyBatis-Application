package designPattern.structure.bridge;

/**
 * 品牌类维度
 * @author libo
 *
 */
public interface Brand {
	void sale();
}

class Lenovo implements Brand{

	@Override
	public void sale() {
		System.out.println("联想");
	}
	
}
class Dell implements Brand{

	@Override
	public void sale() {
		System.out.println("戴尔");
	}
	
}
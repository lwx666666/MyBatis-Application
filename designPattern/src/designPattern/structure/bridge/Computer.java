package designPattern.structure.bridge;
/**
 * 电脑类维度
 * @author libo
 *
 */
public abstract class Computer {
	// 组合品牌
	protected Brand brand;
	
	public Computer(Brand brand) {
		this.brand = brand;
	}
	
	public abstract void sale();
}

class Desktop extends Computer{

	public Desktop(Brand brand) {
		super(brand);
	}

	@Override
	public void sale() {
		this.brand.sale();
		System.out.println("台式电脑");
	}
}

class Laptop extends Computer{

	public Laptop(Brand brand) {
		super(brand);
	}

	@Override
	public void sale() {
		this.brand.sale();
		System.out.println("笔记本电脑");
	}
}

class Pad extends Computer{

	public Pad(Brand brand) {
		super(brand);
	}

	@Override
	public void sale() {
		this.brand.sale();
		System.out.println("平板电脑");
	}
}
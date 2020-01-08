package lamda.test;

public class LamdaDemo {
	public static void main(String[] args) {
		// 1.普通接口的实例化，匿名内部类方式
		ILamda lamda = new ILamda() {
			@Override
			public int get(int a, int b) {
				b = 10;
				System.out.println(a * b);
				return b;
				
			}

//			@Override
//			public void test() {
//				
//			}
		};
		lamda.get(3, 5);
//		Lamda表达式，有参(无参)，单行语句(对接口中方法的实现)
//		getMessage(()->System.out.println("无参，单行语句"));
		
//		Lamda表达式，有参(无参)，多行语句
		/*getMessage(()->{
			int a,b;
			a = b = 3;
			System.out.println(a * b);
		});*/
//		lamda表达式，有参(无参)，表达式,lamda表达式必须使用函数式接口，函数式接口中只能有一个抽象方法
		getMessage((a,b)-> a * b);// 必须实现的方法是带有返回值的
		// lamda表达式，有参(无参)，return 表达式
		getMessage((a,b)->{return a + b;});
	}
	public static void getMessage(ILamda lamda) {
//		lamda.test();
//		lamda.fun();
		System.out.println(lamda.get(1, 3));
		
	}
}


interface ILamda{
	//void print(String message);
	//void test();
	default void fun() {
		System.out.println("接口中可以定义default方法，不需要任何类实现，由其子类调用");
	}
	int get(int a,int b);
}
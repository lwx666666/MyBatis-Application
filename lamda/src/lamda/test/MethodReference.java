package lamda.test;
/**
 * 函数式接口只能有一个方法
 * 方法的引用有四种：
 * 1.引用静态方法
 * 		类名::静态方法
 * 2.对象引用方法
 * 		对象::普通方法
 * 3.引用特定类型的方法
 * 		类名::特定方法
 * 4.引用构造方法
 * 		类名::new
 * @author libo
 *
 */
public class MethodReference {
	public static void main(String[] args) {
		// 静态方法引用
		IStaticMethod<Integer,String> msg = String::valueOf;
		String strVal = msg.convertMethod(100);
		System.out.println(strVal);
		// 类中特定方法(覆写的方法)
		ISpecialMethod<String> comp = String::compareTo;
		int r = comp.compareMethod("A", "a");
		System.out.println(r);
		// 对象方法引用
		IObjectMethod<String> upp = "hello"::toUpperCase;
		String upperStr = upp.upper();
		System.out.println(upperStr);
		// 构造方法引用
		IConstructorMethod<Book> constr = Book::new;
		Book book = constr.crate("python", 89.88);
		System.out.println(book);
	}
}
/**
 * 静态方法引用接口
 * @author libo
 *
 * @param <P>
 * @param <R>
 */
@FunctionalInterface
interface IStaticMethod<P,R>{
	public R convertMethod(P ps);
}
/**
 * 类中特定方法引用接口
 * @author libo
 *
 */
@FunctionalInterface
interface ISpecialMethod<P>{
	public int compareMethod(P p1,P p2);
}
/**
 * 对象方法引用接口
 * @author libo
 *
 */
@FunctionalInterface
interface IObjectMethod<R>{
	public R upper();
}

/**
 * 构造方法引用接口
 * @author libo
 *
 */
@FunctionalInterface
interface IConstructorMethod<C>{
	public C crate(String name,double price);
}

class Book{
	private String name;
	private double price;
	public Book(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", price=" + price + "]";
	}
	
}

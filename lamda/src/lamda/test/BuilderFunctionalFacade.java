package lamda.test;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * jdk1.8内建函数式接口
 * 1.功能型接口，有参数，有返回值
 * 2.消费型接口，有参数，无返回值
 * 3.供给型接口，无参数，又返回值
 * 4.断言型接口，返回boolean值
 * @author libo
 *
 */
public class BuilderFunctionalFacade {
	
	public static void main(String[] args) {
		// 功能型接口，有参数，有返回值
		Function<String,Boolean> fun = "++hh"::startsWith;
		Boolean flag = fun.apply("+");
		System.out.println(flag);
		// 消费型接口，有参数无返回值
		Consumer<Object> con = System.out::println;
		con.accept(new Date().getTime());
		// 供给型接口
		Supplier<String> sup = "test"::toUpperCase;
		String r = sup.get();
		con.accept(r);
		// 断言型接口
		Predicate<String> pre = "fsfs lll"::contains;
		con.accept(pre.test(" "));
	}
}

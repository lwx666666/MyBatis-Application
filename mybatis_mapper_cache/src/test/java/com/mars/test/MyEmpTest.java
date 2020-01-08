package com.mars.test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mars.dao.MyEmpMapperDynamicSQL;
import com.mars.dao.UserMapper;
import com.mars.model.MyDept;
import com.mars.model.MyEmp;

public class MyEmpTest {
	static SqlSessionFactory sqlSessionFactory = null;
	@BeforeClass
	public static void before() {
		
		Reader reader = null;
		
		try {
			reader = Resources.getResourceAsReader("mybatis_config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	
	
	@Test
	public void firstLevelCacheTest() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MyEmpMapperDynamicSQL mapper = sqlSession.getMapper(MyEmpMapperDynamicSQL.class);
		try {
			/**
			 * 一级缓存：sqlSession级别缓存，也称为本地缓存
			 * 数据库第一次查询后，会将数据存入缓存，如果第二次要查询，直接从缓存中取
			 * 如果配置了二级缓存，在当前回话数据提交后，会将数据保存到二级缓存中，当session想再次查询的话，就会从二级缓存中先查找
			 */
			MyEmp emp1 = mapper.findEmpById(7369);
			System.out.println(emp1);
			sqlSession.commit();
			// 增删改操作会使缓存中数据破坏
//			int n = mapper.addEmp(new MyEmp(9499,"T3","TJ3",null,new Date(),1299.0,null,new MyDept(40)));
//			System.out.println("添加数据：" + n); 
//			sqlSession.clearCache(); // 清除缓存
			MyEmp emp2 = mapper.findEmpById(7369);
			System.out.println(emp1 == emp2);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	@Test
	public void secondLevelCacheTest() {
		// 二级缓存（全局缓存），基于namespace的缓存，一个namespace对应一个缓存
		/**
		 * 一个会话会查询一条数据，这条数据会被放到当前的会话的一级缓存中；
		 * 如果当前回话关闭，则mybatis会将回话中的数据存入二级缓存中，新的会话查询信息会从二级缓存中取；
		 * 不同的namespace查询出的数据会存入自己对应的二级缓存中。
		 * 使用：
		 * 	开启二级缓存<setting name="cacheEnabled" value="true"/>，cacheEnabled为false关闭二级缓存
		 * 	在指定的命名空间下设置<cache></cache>
		 *  pojo需要实现序列化接口
		 *  二级缓存注意：
		 *  	在第一个sqlSession查询后必须提交或者关闭才会将一级缓存中数据存入二级缓存
		 *  	useCache：查询标签中的useCache默认是true如果设置为false则不会从二级缓存中取，一级缓存依然有效
		 *  	增删改标签默认为flushCache="true"，在查询之间如果存在增删改操作，由于增删改会清除缓存所以二级缓存也不能使用
		 *  	如果设置查询标签flushCache="true"，则每次查询都会清空一级缓存，二级缓存不可用
		 *  	执行sqlSession1.clearCache()方法只会清除一级缓存，不能清除二级缓存
		 *  	localCacheScope：本地缓存作用域，默认为SESSION，当前回话中使用缓存，如果取值STATEMENT，则当前回话不会使用缓存
		 *  	缓存的执行顺序：
		 *  		先二级缓存，然后一级缓存，然后到数据库
		 *  使用第三方缓存作为二级缓存策略：
		 *  	1.导入第三方缓存包
		 *  	2.导入与第三方缓存整合的适配包
		 *  	3.在mapper.xml中引入第三方缓存
		 */
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		MyEmpMapperDynamicSQL mapper1 = sqlSession1.getMapper(MyEmpMapperDynamicSQL.class);
		MyEmpMapperDynamicSQL mapper2 = sqlSession2.getMapper(MyEmpMapperDynamicSQL.class);
		try {
			
			MyEmp emp1 = mapper1.findEmpById(7369);
			System.out.println(emp1);
			sqlSession1.clearCache();
			sqlSession1.close();
			MyEmp emp2 = mapper2.findEmpById(7369);
			System.out.println(emp2);
			sqlSession2.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	
	@Test
	public void testUserEhcache() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		Map<String, Object> user = mapper.getUserAsMap(7);
		System.out.println(user);
		sqlSession.close();
		
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
		Map<String, Object> user2 = mapper2.getUserAsMap(7);
		System.out.println(user2);
		
	}
}

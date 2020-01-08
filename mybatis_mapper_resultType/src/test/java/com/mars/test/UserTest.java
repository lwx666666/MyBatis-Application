package com.mars.test;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mars.dao.UserMapper;
import com.mars.model.User;

public class UserTest {
	@Test
	public void userAddTest() throws Exception {
		// SqlSessionFactory和JDBC中的Connection对象一样都是非线程安全的
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setId(null);
		user.setAge(25);
		user.setEmail(null);
		user.setUsername("域名");
		mapper.addUser(user);
		System.out.println(user.getId());
		sqlSession.commit(); // 增删改必须提交事务
		sqlSession.close();
		reader.close();
	}
	
	@Test
	public void likeSelTest() throws Exception {
		// SqlSessionFactory和JDBC中的Connection对象一样都是非线程安全的
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = null;
		try {
			users = mapper.selectByNameLike("%s%");
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(users);
		sqlSession.commit(); // 增删改必须提交事务
		sqlSession.close();
		reader.close();
	}
	
	@Test
	public void mapSelTest() throws Exception {
		// SqlSessionFactory和JDBC中的Connection对象一样都是非线程安全的
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//		Map<String, Object> map = mapper.getUserAsMap(3);
		Map<Integer, User> map2 = mapper.getUserAsMap2("%%");
		System.out.println(map2);
		sqlSession.commit(); // 增删改必须提交事务
		sqlSession.close();
		reader.close();
	}
	
	@Test
	public void getUsersResultMapTest() throws Exception {
		// SqlSessionFactory和JDBC中的Connection对象一样都是非线程安全的
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//		Map<String, Object> map = mapper.getUserAsMap(3);
		List<User> users= mapper.getUsersResultMap();
		System.out.println(users);
		sqlSession.commit(); // 增删改必须提交事务
		sqlSession.close();
		reader.close();
	}
}

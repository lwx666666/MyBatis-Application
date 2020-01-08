package com.mars.test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mars.dao.IMemberDao;
import com.mars.model.Member;

public class MyBatisTest {
	
	
	@Test
	public void saveMemberTest() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession s = ssf.openSession(false);
		try {
			IMemberDao memberDao = s.getMapper(IMemberDao.class);
			Member m = new Member();
			m.setMid(002);
			m.setName("XURTER");
			m.setAge(20);
			m.setEmail("xrt");
			memberDao.insert(m);
		} catch (Exception e) {
			s.rollback();
			e.printStackTrace();
		}finally {
			s.commit();
			s.close();
			reader.close();
		}
	}
	
	@Test
	public void updateMemberTest() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession s = ssf.openSession(false);
		try {
			IMemberDao memberDao = s.getMapper(IMemberDao.class);
			Member m = new Member();
			m.setMid(001);
			m.setName("XURSTON");
			m.setAge(25);
			m.setEmail("XST");
			memberDao.updateById(m);
		} catch (Exception e) {
			s.rollback();
			e.printStackTrace();
		}finally {
			s.commit();
			s.close();
			reader.close();
		}
	}
	
	@Test
	public void deleteMemberTest() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession s = ssf.openSession(false);
		try {
			IMemberDao memberDao = s.getMapper(IMemberDao.class);
			memberDao.deleteById(1);
		} catch (Exception e) {
			s.rollback();
			e.printStackTrace();
		}finally {
			s.commit();
			s.close();
			reader.close();
		}
	}
	
	@Test
	public void findMemberTest() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession s = ssf.openSession(false);
		try {
			IMemberDao memberDao = s.getMapper(IMemberDao.class);
			Member m = memberDao.findById(2);
			System.out.println(m.getName());
		} catch (Exception e) {
			s.rollback();
			e.printStackTrace();
		}finally {
			s.commit();
			s.close();
			reader.close();
		}
	}
	
	@Test
	public void findMemberByNameTest() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession s = ssf.openSession(false);
		try {
			IMemberDao memberDao = s.getMapper(IMemberDao.class);
			Member m = memberDao.findByName("XURTER");
			System.out.println(m.getName());
		} catch (Exception e) {
			s.rollback();
			e.printStackTrace();
		}finally {
			s.commit();
			s.close();
			reader.close();
		}
	}
	
	@Test
	public void findMemberByNameAndEmailTest() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession s = ssf.openSession(false);
		try {
			IMemberDao memberDao = s.getMapper(IMemberDao.class);
//			List<Member> ms = memberDao.findByNameAndEmail("X", "xrt");
			Map<String,String> map = new HashMap<String,String>();
			map.put("name", "X");
			map.put("email", "xrt");
			List<Member> ms = memberDao.findByNameAndEmail2(map);
			System.out.println(ms.size());
		} catch (Exception e) {
			s.rollback();
			e.printStackTrace();
		}finally {
			s.commit();
			s.close();
			reader.close();
		}
	}
}

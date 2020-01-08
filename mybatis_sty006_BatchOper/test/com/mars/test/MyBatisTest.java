package com.mars.test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mars.dao.IMemberDao;
import com.mars.dao.IMyEmpDao;
import com.mars.model.Member;
import com.mars.model.MyEmp;

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
	
	@Test
	public void dynamicSQLTest() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession s = ssf.openSession(false);
		try {
			IMyEmpDao empDao = s.getMapper(IMyEmpDao.class);
			MyEmp emp = new MyEmp();
			emp.setJob("CLERK");
			emp.setEname("A");
			emp.setSal(800.0);
//			List<MyEmp> emps = empDao.findAllByIf(emp);
//			List<MyEmp> emps = empDao.findListByChoose(emp);
//			List<MyEmp> emps = empDao.finListdByTrim(emp);
			List<MyEmp> emps = empDao.findListByWhere(emp);
			for(MyEmp e : emps) {
				System.out.println(e.getEname());
			}
			
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
	public void BatchDelMemberTest() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		SqlSession s = ssf.openSession(false);
		try {
			IMemberDao memberDao = s.getMapper(IMemberDao.class);
//			List<Integer> list = new ArrayList<Integer>();
//			list.add(1);
//			list.add(2);
//			String [] names = {"fsfsfs","aga"};
//			int num = memberDao.deleteByList(list);
//			int num = memberDao.deleteByArray(names);
			Set<Member> members = new HashSet<Member>();
			Member m1 = new Member();
			m1.setName("kkk");
			m1.setAge(23);
			m1.setMid(9);
			m1.setEmail("jjjj");
			
			Member m2 = new Member();
			m2.setName("lgd");
			m2.setAge(28);
			m2.setMid(8);
			m2.setEmail("hfh");
			members.add(m1);
			members.add(m2);
			int num = memberDao.insertBySet(members);
			System.out.println("新增了" + num);
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

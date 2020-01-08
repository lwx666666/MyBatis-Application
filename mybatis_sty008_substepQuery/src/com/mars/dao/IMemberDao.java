package com.mars.dao;

import java.util.List;

import com.mars.model.Member;

public interface IMemberDao {
	
	/**
	 * 查询所有
	 * @return Member集合
	 */
	List<Member> findAll();
	
}

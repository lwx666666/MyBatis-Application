package com.mars.model;

public class Member {
	private Integer m_id;
	private String m_name;
	private Integer m_age;
	private String m_email;
	public Integer getM_id() {
		return m_id;
	}
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public Integer getM_age() {
		return m_age;
	}
	public void setM_age(Integer m_age) {
		this.m_age = m_age;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	@Override
	public String toString() {
		return "Member [m_id=" + m_id + ", m_name=" + m_name + ", m_age=" + m_age + ", m_email=" + m_email + "]";
	}
	
}

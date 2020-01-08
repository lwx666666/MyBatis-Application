package com.mars.model;

import java.util.List;

public class MyDept {
	private Integer deptno;
	private String dname;
	private String loc;
	private List<MyEmp> emps;
	public List<MyEmp> getEmps() {
		return emps;
	}
	public void setEmps(List<MyEmp> emps) {
		this.emps = emps;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "MyDept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
	
}

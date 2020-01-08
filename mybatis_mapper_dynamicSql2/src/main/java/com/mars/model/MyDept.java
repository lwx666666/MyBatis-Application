package com.mars.model;

public class MyDept {
	private Integer deptno;
	private String dname;
	private String loc;
	
	
	public MyDept(Integer deptno) {
		super();
		this.deptno = deptno;
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

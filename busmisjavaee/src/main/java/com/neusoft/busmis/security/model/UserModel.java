package com.neusoft.busmis.security.model;

import java.io.Serializable;
import java.util.Date;
//用户的Model类
@SuppressWarnings("serial")
public class UserModel implements Serializable {
	private String id=null;
	private String password=null;
	private String name=null;
	private String role=null;
	private int age=0;
	private Date joinDate=null;
	private String status=null; //用户的状态， Y:激活， N:不激活的
	private String statusName=null; //状态的名称，不从数据库中取得。
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusName() {
		if(status!=null&&status.equals("Y")) {
			statusName="已激活";
		}
		else {
			statusName="未激活";
		}
		return statusName;
	}
	public void setStatusName(String statusName) {
		
		this.statusName = statusName;
	}
	
	
}

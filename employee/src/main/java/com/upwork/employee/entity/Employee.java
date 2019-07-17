package com.upwork.employee.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable{

	@Id
	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}

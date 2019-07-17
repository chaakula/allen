package com.upwork.employee.model.request;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author Chandra Sekhar Babu A
 *
 */
@JsonInclude(Include.NON_NULL)
public class UserDetails extends RequestViewModel implements Serializable {

	private static final long serialVersionUID = -8908198542640865166L;

	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String userName;
	private String password;

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetails(String firstName, String middleName, String lastName, String email, String userName,
			String password) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}

	public UserDetails(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * validate the registration form with mandatory fields filled or not
	 * 
	 * @return boolean
	 */
	public boolean isValidRequest() {

		if (!StringUtils.isEmpty(this.getUserName()) && !StringUtils.isEmpty(this.getPassword())) {
			return true;
		}
		return false;
	}

}

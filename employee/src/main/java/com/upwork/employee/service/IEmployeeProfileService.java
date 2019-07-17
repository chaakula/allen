package com.upwork.employee.service;

import com.upwork.employee.exception.AppException;
import com.upwork.employee.model.request.UserDetails;

/**
 * Employee registration service class
 * 
 * @author Chandra Sekhar Babu A
 *
 */
public interface IEmployeeProfileService {

	public UserDetails updateProfile(UserDetails emp) throws AppException;
	
}

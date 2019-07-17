/**
 * 
 */
package com.upwork.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upwork.employee.entity.Employee;
import com.upwork.employee.exception.AppException;
import com.upwork.employee.model.request.UserDetails;
import com.upwork.employee.repository.EmployeeProfileRepository;
import com.upwork.employee.util.EmployeeUtil;

/**
 * @author Chandra Sekhar Babu A
 *
 */
@Service
public class EmployeeProfileServiceImpl implements IEmployeeProfileService {

	@Autowired
	EmployeeProfileRepository empProfileRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upwork.employee.service.IEmployeeRegistrationService#registerUser(com.
	 * upwork.employee.model.UserDetails)
	 */
	@Override
	public UserDetails updateProfile(UserDetails userDetails) throws AppException {
		Employee empResp = empProfileRepo.save(EmployeeUtil.transformToEmployee(userDetails));
		return EmployeeUtil.transformToUserDetails(empResp);
	}

}

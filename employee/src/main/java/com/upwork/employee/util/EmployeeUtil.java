package com.upwork.employee.util;

import com.upwork.employee.entity.Employee;
import com.upwork.employee.model.request.UserDetails;

public class EmployeeUtil {

	public static Employee transformToEmployee(UserDetails ud) {
		Employee emp = new Employee(ud.getUserName(), ud.getPassword());
		return emp;
	}

	public static UserDetails transformToUserDetails(Employee ud) {
		UserDetails emp = new UserDetails(ud.getUserName(), ud.getPassword());
		return emp;
	}

}

package com.upwork.employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.upwork.employee.entity.Employee;

public interface EmployeeProfileRepository extends CrudRepository<Employee, String>{

}

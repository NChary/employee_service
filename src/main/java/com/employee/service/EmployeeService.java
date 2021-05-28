package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeService {
	String saveEmployeeData(Employee employee);
	List<Employee> getEmployees();
	String updateEmployee(Employee employee);
	String deleteEmployee(Employee employee);
	String deleteByEid(Integer eid);
}

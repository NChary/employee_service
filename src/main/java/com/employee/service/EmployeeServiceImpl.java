package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public String saveEmployeeData(Employee employee) {
		// Repository to store data into database
		employeeRepository.save(employee);
		return "Got request to Service layer : "+employee.getEname();
	}

	/**
	 * This method returns all employees
	 */
	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	/**
	 * This method update employee details
	 */
	
	@Override
	public String updateEmployee(Employee employee) {
		employeeRepository.save(employee);              // save() - if id doesnt exit in the database then create it as new record; id is existed - update data
		return "Updated successfully";
	}

	@Override
	public String deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
		return "Employee is deleted successfully";
	}

	@Override
	public String deleteByEid(Integer eid) {
		System.out.println("Employee ID : "+eid);
		employeeRepository.deleteById(eid);
		return "Employee is deleted successfully";
	}

}

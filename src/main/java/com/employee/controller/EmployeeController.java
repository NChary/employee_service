package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController // This annotation used to make java class as RESTful controller
@RequestMapping("/v1")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	// test service
	@GetMapping("/greet")
	public String greeting() {
		return "Welcome to Spring Boot RESTful Webservice";
	}
	
	// Service1: Save data into database
	@PostMapping("/employee")
	public String saveEmployee(@RequestBody Employee employee)
	{
		return employeeService.saveEmployeeData(employee);
	}
	
	// Fetch data from Database
	@GetMapping("/employee")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getEmployees();
	}
	
	//Update Data
	@PutMapping("/employee")
	public String updateEmployee(@RequestBody Employee employee)
	{
		return employeeService.updateEmployee(employee);
	}
	
	//Delete a record
	@DeleteMapping("/employee")
	public String deleteEmployee(@RequestBody Employee employee) 
	{
		return employeeService.deleteEmployee(employee);
	}
	
	//Delete by eid
	@DeleteMapping("/employee/{employeeId}")
	public String deleteByEid(@PathVariable Integer employeeId) 
	{
		return employeeService.deleteByEid(employeeId);
	}
	
}
    
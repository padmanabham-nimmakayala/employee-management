package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {
	
@Autowired	
private EmployeeService employeeService;

private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);


	@PostMapping("/employees")   
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		logger.info("employe active field is "+emp.getLocked());
		employeeService.createEmployee(emp);
		return null;

} 
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		
		return employeeService.fetchAllEmployees();
	 
		
	} 
	@PutMapping("/employees/{id}")
	public void updateEmployee(@PathVariable(value="id")Long id,@Valid @RequestBody Employee emp) {
		logger.info("employe email is.");
	employeeService.updateEmployeeDetails(id,emp);
	}
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable(value="id")Long employeeId) {
		employeeService.deleteEmployeeDetails(employeeId);
	}
} 
	
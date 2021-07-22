package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public void createEmployee(@Valid Employee emp) {
		employeeRepository.save(emp);
		
		
		
	}

	public void updateEmployeeDetails(Long id, @Valid Employee emp) {
	Optional<Employee>empDetails=	employeeRepository.findById(id);
		if(empDetails.isPresent()) {
			Employee dbEmployee = empDetails.get();
			dbEmployee.setEmailid(emp.getEmailid());
			dbEmployee.setFirstName(emp.getFirstName());
			dbEmployee.setLastName(emp.getLastName());
			dbEmployee.setPassportNumber(emp.getPassportNumber());
			dbEmployee.setLocked(emp.getLocked());
			
			employeeRepository.save(dbEmployee);
		}else {
			System.out.println("Employee record is not exists with this id"+id);
		}
		

		
	}

	public List<Employee> fetchAllEmployees() {
		List<Employee>ls=employeeRepository.findAll();
		return ls;
		
	}

	public void deleteEmployeeDetails(Long employeeId) {
		Optional<Employee>empDetails=	employeeRepository.findById(employeeId);
		if(empDetails.isPresent()) {
			employeeRepository.delete(empDetails.get());
		}else {
			System.out.println("record does not exist with this id"+ employeeId);
		
	}

	
		
		
	}

}

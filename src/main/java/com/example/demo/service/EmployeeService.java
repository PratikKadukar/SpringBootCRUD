package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		
		Employee savedEmployee=employeeRepo.save(employee);
		return savedEmployee;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employeelist=employeeRepo.findAll();
		return employeelist;
	}

	@Override
	public Employee getEmpById(int eId) {
		return employeeRepo.findById(eId).get();
		
	}

	public void deleteEmpById(int eid) {
		employeeRepo.deleteById(eid);
		
	}
}

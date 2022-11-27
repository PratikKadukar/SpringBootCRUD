package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeServiceInterface {

	Employee addEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmpById(int eId);

	void deleteEmpById(int eid);

}

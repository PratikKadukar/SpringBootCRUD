package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/code")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;
	
	@PostMapping("save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

		Employee employeeSaved = employeeServiceInterface.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);

	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee>listOfAllEmployees=employeeServiceInterface.getAllEmployees();
		
		return new ResponseEntity<List<Employee>>(listOfAllEmployees,HttpStatus.OK);
		
	}
	
	@GetMapping("/emp/{empid}")
	public ResponseEntity<Employee>getEmpById(@PathVariable("empid") int eId){
		Employee employeeRetrieved=employeeServiceInterface.getEmpById(eId);
		return new ResponseEntity<Employee>(employeeRetrieved,HttpStatus.OK);
	}
	
	@DeleteMapping("/emp/{empid}")
	public ResponseEntity<Void>deleteEmpById(@PathVariable("empid")int eid){
		employeeServiceInterface.deleteEmpById(eid);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {

		Employee employeeSaved = employeeServiceInterface.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);

	}

}
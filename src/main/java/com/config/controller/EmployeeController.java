package com.config.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.config.dao.EmployeeDaoImpl;
import com.config.model.Employee;

@RestController
public class EmployeeController {
	
	private EmployeeDaoImpl employeeDaoImpl;
	
	public EmployeeController(EmployeeDaoImpl employeeDaoImpl) {
		
		this.employeeDaoImpl=employeeDaoImpl;
	}
	
	@PostMapping("/add")
	public Employee saveEmployee(@RequestBody Employee employee) {
		
		Employee savedEmployee = employeeDaoImpl.saveEmployee(employee);
		
		return savedEmployee;
		
	}
	
	@PostMapping("/addMany")
	public List<Employee> saveManyEmployee(@RequestBody List<Employee> employee){
		
		List<Employee> saveAll = employeeDaoImpl.saveAll(employee);
		
		return saveAll;
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getEmployee(@PathVariable String id) {
		
		Employee savedEmployee = employeeDaoImpl.getEmployee(id);
		if(savedEmployee.equals(null)){
			return new ResponseEntity<Object>("Wrong Id", HttpStatus.NOT_FOUND);
		}
		
		Employee employee = employeeDaoImpl.getEmployee(id);
		
		return new ResponseEntity<Object>(employee, HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public List<Employee> findAllEmployee(){
		
		List<Employee> allEmployee = employeeDaoImpl.getAllEmployee();
		return allEmployee;
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Object> removeEmployee(@PathVariable String id){
		
		Employee savedEmployee = employeeDaoImpl.getEmployee(id);
		if(savedEmployee.equals(null)){
			return new ResponseEntity<Object>("Wrong Id", HttpStatus.NOT_FOUND);
		}
		
		Employee removedEmployee= employeeDaoImpl.removeEmployeeById(id);
		
		return new ResponseEntity<Object>(removedEmployee.getEmployeeId() +" is removed", HttpStatus.OK);
	}
}

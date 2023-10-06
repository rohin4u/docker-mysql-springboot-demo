package com.config.dao;

import java.util.List;

import com.config.model.Employee;

public interface EmployeeDao {
	
	public Employee saveEmployee(Employee employee);
	public Employee getEmployee(String id);
	public List<Employee> getAllEmployee();
	public Employee removeEmployeeById(String id);
	public List<Employee> saveAll(List<Employee> employees);

}

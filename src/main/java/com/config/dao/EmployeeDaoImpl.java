package com.config.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.config.model.Employee;
import com.config.repository.EmployeeRepository;

@Component
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public Employee saveEmployee(Employee employee) {
		
		Employee savedEmployee = employeeRepo.save(employee);
		
		return savedEmployee;
	}

	@Override
	public Employee getEmployee(String empId) {
		
		Employee employee = employeeRepo.findById(empId).get();
		
		
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> allEmployee = employeeRepo.findAll();
		return allEmployee;
	}
	
	@Override
	public Employee removeEmployeeById(String id) {
		
		Employee employee = employeeRepo.findById(id).get();
		
		employeeRepo.delete(employee);
		return employee;
	}

	@Override
	public List<Employee> saveAll(List<Employee> employees) {
		
		List<Employee> allEmployee = employeeRepo.saveAll(employees);
		return allEmployee;
	}

}

package com.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.config.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{

}

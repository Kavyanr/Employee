package com.capgemini.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.application.model.EmployeeModel;
import com.capgemini.application.repository.EmployeeRepo;


@Service
@Transactional
public class EmpServiceImp implements EmployeeService{

	
	@Autowired
	private EmployeeRepo employee;
	@Override
	public List<EmployeeModel> getEmployees() {
         return employee.findAll();
	}

	@Override
	public Optional<EmployeeModel> getEmployeeById(int id) {
		return employee.findById(id);
	}

	@Override
	public EmployeeModel addNewEmployee(EmployeeModel emp) {
		return employee.save(emp);
	}

	@Override
	public EmployeeModel updateEmployee(EmployeeModel emp) {
		return employee.save(emp);
	}

	@Override
	public void deleteEmployeeById(int id) {
		employee.deleteById(id);
	}

	@Override
	public void deleteAllEmployees() {
		employee.deleteAll();
		
	}

	
}

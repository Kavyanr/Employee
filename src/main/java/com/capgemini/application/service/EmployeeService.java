package com.capgemini.application.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.application.model.EmployeeModel;

public interface EmployeeService {

	public List<EmployeeModel> getEmployees() ;
	 public Optional<EmployeeModel> getEmployeeById(int id);
	 public EmployeeModel addNewEmployee(EmployeeModel emp) ;
	  public EmployeeModel updateEmployee(EmployeeModel emp);
	  public void deleteEmployeeById(int empid);
	  public void deleteAllEmployees();
}

package com.capgemini.application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.application.model.EmployeeModel;
import com.capgemini.application.service.EmployeeService;

@RestController

public class EmpController {

	@Autowired
	private EmployeeService service;
	
	@RequestMapping(value="/employee/all", method=RequestMethod.GET)
	public List<EmployeeModel> getEmployees() {
		return service.getEmployees(); 
	}
	
	 @RequestMapping(value= "/employee/{id}", method= RequestMethod.GET)
	    public EmployeeModel getEmployeeById(@PathVariable int id) throws Exception {
	      
	        Optional<EmployeeModel> emp =  service.getEmployeeById(id);
	        if(!emp.isPresent())
	            throw new Exception("Could not find employee with id- " + id);
	 
	        return emp.get();
	    }
	 
	 @RequestMapping(value="/employee/add", method=RequestMethod.POST)
	 public EmployeeModel createEmployee(@RequestBody EmployeeModel newemp) {
	        return service.addNewEmployee(newemp);
	    }
	 
	 @RequestMapping(value="/employee/update/{id}", method=RequestMethod.PUT)
	 public EmployeeModel updateEmployee(@RequestBody EmployeeModel updateemp, @PathVariable int id) throws Exception {
		 Optional<EmployeeModel> emp =  service.getEmployeeById(id);
	        if (!emp.isPresent())
	            throw new Exception("Could not find employee with id- " + id);
	  
	        if(updateemp.getName() == null || updateemp.getName().isEmpty())
	        	updateemp.setName(emp.get().getName());
	        if(updateemp.getDepartment() == null || updateemp.getDepartment().isEmpty())
	        	updateemp.setDepartment(emp.get().getDepartment());
	        if(updateemp.getAge() == 0)
	        	updateemp.setAge(emp.get().getAge());
	 
	       
	        updateemp.setId(id);
	        return service.updateEmployee(updateemp);
	
      }
	 
	 @RequestMapping(value= "/employee/delete/{id}", method= RequestMethod.DELETE)
	    public void deleteEmployeeById(@PathVariable int id) throws Exception {
	     
	        Optional<EmployeeModel> emp =  service.getEmployeeById(id);
	        if(!emp.isPresent())
	            throw new Exception("Could not find employee with id- " + id);
	 
	        service.deleteEmployeeById(id);
	    }
	 
	    @RequestMapping(value= "/employee/deleteall", method= RequestMethod.DELETE)
	    public void deleteAll() {
	        service.deleteAllEmployees();
	    }
	}
	 


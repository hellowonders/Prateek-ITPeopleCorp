package com.itpeoplecorp.com.employee.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itpeoplecorp.com.employee.model.Employee;
import com.itpeoplecorp.com.employee.service.EmployeeSearchService;

@RestController
public class EmployeeSearchController {

	@Autowired
	EmployeeSearchService employeeSearchService;

	@GetMapping("/getMatchingEmployees/{filter}")
	public List<Employee> getMatchingEmployees(@PathVariable("filter") String filter) {
		return employeeSearchService.getFilteredEmployees(filter);		
	}
}

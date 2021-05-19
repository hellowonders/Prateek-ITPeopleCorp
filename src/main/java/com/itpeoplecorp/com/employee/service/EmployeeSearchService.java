package com.itpeoplecorp.com.employee.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpeoplecorp.com.employee.dao.EmployeeSearchRepository;
import com.itpeoplecorp.com.employee.model.Employee;

@Service
public class EmployeeSearchService {
	
private static final String MATCHING_NAME = "matchingName";
private static final String AGE_GREATER_THAN = "ageGreaterThan";
private static final String AGE_LESS_THAN = "ageLessThan";
private static final String SALARY_GREATER_THAN = "salaryGreaterThan";
private static final String SALARY_LESS_THAN = "salaryLessThan";
private static final String ADDRESS_CONTAINS = "addressContains";
private static final String MATCHING_BLOOD_GROUP = "matchingBloodGroup";

	@Autowired
	EmployeeSearchRepository employeeSearchRepository;
	
	public List<Employee> getFilteredEmployees(String filter) {
		List<Employee> employeees =  (List<Employee>) employeeSearchRepository.findAll();
		
		if(filter.equals(MATCHING_NAME)) {
			return employeees.stream().filter(e -> e.getName().contains("Marc")).collect(Collectors.toList());
		} else if (filter.equals(AGE_GREATER_THAN)) {
			return employeees.stream().filter(e -> Period.between(e.getDob().toLocalDate(), LocalDate.now()).getYears() > 26 ).collect(Collectors.toList());
		} else if (filter.equals(AGE_LESS_THAN)) {
			return employeees.stream().filter(e -> Period.between(e.getDob().toLocalDate(), LocalDate.now()).getYears() < 26 ).collect(Collectors.toList());
		} else if (filter.equals(SALARY_GREATER_THAN)) {
			return employeees.stream().filter(e -> Double.compare(e.getSalary(), Double.valueOf(1000000)) > 0 ).collect(Collectors.toList());
		} else if (filter.equals(SALARY_LESS_THAN)) {
			return employeees.stream().filter(e -> Double.compare(e.getSalary(), Double.valueOf(1000000)) < 0 ).collect(Collectors.toList());
		} else if (filter.equals(ADDRESS_CONTAINS)) {
			return employeees.stream().filter(e -> e.getAddress().contains("Delhi")).collect(Collectors.toList());
		} else if (filter.equals(MATCHING_BLOOD_GROUP)) {
			return employeees.stream().filter(e -> e.getBloodGroup().equals("B+")).collect(Collectors.toList());
		}
		return employeees;
	}
}

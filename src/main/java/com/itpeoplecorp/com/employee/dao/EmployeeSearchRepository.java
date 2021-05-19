package com.itpeoplecorp.com.employee.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itpeoplecorp.com.employee.model.Employee;

@Repository
public interface EmployeeSearchRepository extends CrudRepository<Employee,Long> {
}

package com.inglot.springboot.thymeleafdemo.service;


import com.inglot.springboot.thymeleafdemo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public List<Employee> findAll();

    public Optional<Employee> findById(int theId);

    public void save(Employee employee);

    public void deleteById(int id);

}

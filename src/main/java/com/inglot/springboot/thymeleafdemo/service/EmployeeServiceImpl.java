package com.inglot.springboot.thymeleafdemo.service;

import com.inglot.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.inglot.springboot.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }



    @Override
    public List<Employee> findAll() {

        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Optional<Employee> findById(final int id) {
        Optional<Employee> maybeEmployee = employeeRepository.findById(id);

        if (maybeEmployee.isPresent()) {
            return  maybeEmployee;
        } else {
            throw new RuntimeException("There is no employee with such id: " + id);
        }
    }

    @Override
    public void save(Employee employee) {

        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {

        employeeRepository.deleteById(id);
    }
}

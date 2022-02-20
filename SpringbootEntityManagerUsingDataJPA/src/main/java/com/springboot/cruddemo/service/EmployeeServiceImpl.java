
package com.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.cruddemo.dao.EmployeeRepository;
import com.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(final int id) {
        final Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if (result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("employee id not found: " + id);
        }
        return employee;

    }

    @Override
    public void save(final Employee employye) {
        employeeRepository.save(employye);

    }

    @Override
    public void deleteById(final int id) {
        employeeRepository.deleteById(id);

    }

}

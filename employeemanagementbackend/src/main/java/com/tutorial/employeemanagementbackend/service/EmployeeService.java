package com.tutorial.employeemanagementbackend.service;

import com.tutorial.employeemanagementbackend.model.Employee;
import com.tutorial.employeemanagementbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements com.tutorial.employeemanagmentbackend.service.EmployeeServiceInterface {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee e = employeeRepository.findById(id).orElseThrow();
        e.setFirstName(employee.getFirstName());
        e.setLastName(employee.getFirstName());
        e.setEmail(employee.getEmail());
        return employeeRepository.save(e);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}

package com.example.service;

import com.example.Department.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@ConditionalOnMissingClass
@RequestMapping
@Service
public class EmployeeService {
    private Map<String, Employee> employeeMap;

    @Autowired
    public EmployeeService() {
        this.employeeMap = new HashMap<>();
    }

    public Employee addEmployee(Employee employee) {
        String key = employee.getName() + employee.getSurname();
        employeeMap.put(key, employee);
        return employee;
    }

    public Employee removeEmployee(String name, String surname) {
        String key = name + surname;
        return employeeMap.remove(key);
    }

    public Employee findEmployee(String name, String surname) {
        String key = name + surname;
        return employeeMap.get(key);
    }

    public Collection<Employee> getAllEmployees() {
        return employeeMap.values();
    }

    public Map<String, Employee> getEmployeeMap() {
        return employeeMap;
    }
}
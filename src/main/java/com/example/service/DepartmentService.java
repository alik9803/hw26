package com.example.service;

import com.example.Department.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    @Autowired
    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> getAllEmployeesByDepartment(int departmentId) {
        return employeeService.getEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    public double getSalarySumByDepartment(int departmentId) {
        return employeeService.getEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    public double getMaxSalaryByDepartment(int departmentId) {
        return employeeService.getEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0.0);
    }

    public double getMinSalaryByDepartment(int departmentId) {
        return employeeService.getEmployeeMap().values().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .mapToDouble(Employee::getSalary)
                .min()
                .orElse(0.0);
    }

    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeService.getEmployeeMap().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return null;
    }
}
package com.example.controller;

import com.example.Department.Employee;
import com.example.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping()
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/{name}/{surname}")
    public Employee removeEmployee(@PathVariable String name, @PathVariable String surname) {
        return employeeService.removeEmployee(name, surname);
    }

    @GetMapping("/{name}/{surname}")
    public Employee findEmployee(@PathVariable String name, @PathVariable String surname) {
        return employeeService.findEmployee(name, surname);
    }

    @GetMapping()
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
package com.example.controller;

import com.example.Department.Employee;
import com.example.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesInDepartment(@PathVariable int id) {
        return departmentService.getAllEmployeesByDepartment(id);
    }

    @GetMapping("/{id}/salary/sum")
    public double getSalarySumInDepartment(@PathVariable int id) {
        return departmentService.getSalarySumByDepartment(id);
    }

    @GetMapping("/{id}/salary/max")
    public double getMaxSalaryInDepartment(@PathVariable int id) {
        return departmentService.getMaxSalaryByDepartment(id);
    }

    @GetMapping("/{id}/salary/min")
    public double getMinSalaryInDepartment(@PathVariable int id) {
        return departmentService.getMinSalaryByDepartment(id);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return departmentService.getAllEmployees();
    }
}
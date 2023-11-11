package com.example.Department;
import com.example.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeService();
    }

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee("John", "Doe", 5000, 1);

        Employee addedEmployee = employeeService.addEmployee(employee);

        assertNotNull(addedEmployee);
        assertEquals(employee, addedEmployee);
        assertEquals(1, employeeService.getAllEmployees().size());
    }

    @Test
    public void testRemoveEmployee() {
        Employee employee = new Employee("John", "Doe", 5000, 1);
        employeeService.addEmployee(employee);

        Employee removedEmployee = employeeService.removeEmployee("John", "Doe");

        assertNotNull(removedEmployee);
        assertEquals(employee, removedEmployee);
        assertEquals(0, employeeService.getAllEmployees().size());
    }

    @Test
    public void testFindEmployee() {
        Employee employee = new Employee("John", "Doe", 5000, 1);
        employeeService.addEmployee(employee);

        Employee foundEmployee = employeeService.findEmployee("John", "Doe");

        assertNotNull(foundEmployee);
        assertEquals(employee, foundEmployee);
    }

    @Test
    public void testGetAllEmployees() {
        Employee employee1 = new Employee("John", "Doe", 5000, 1);
        Employee employee2 = new Employee("Jane", "Smith", 6000, 2);

        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);

        assertEquals(2, employeeService.getAllEmployees().size());
        assertTrue(employeeService.getAllEmployees().contains(employee1));
        assertTrue(employeeService.getAllEmployees().contains(employee2));
    }
}
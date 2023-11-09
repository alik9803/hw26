package com.example.Department;

import com.example.Department.Employee;
import com.example.service.DepartmentService;
import com.example.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ServiceTests {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentService departmentService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllEmployeesByDepartment() {
        Employee employee1 = new Employee("John", "Doe", 5000, 1);
        Employee employee2 = new Employee("Jane", "Smith", 6000, 2);
        Employee employee3 = new Employee("Mike", "Johnson", 4500, 1);

        when(employeeService.getEmployeeMap()).thenReturn(Map.of(
                "JohnDoe", employee1,
                "JaneSmith", employee2,
                "MikeJohnson", employee3
        ));

        List<Employee> expectedEmployees = Arrays.asList(employee1, employee3);
        List<Employee> actualEmployees = departmentService.getAllEmployeesByDepartment(1);

        assertEquals(expectedEmployees, actualEmployees);
    }

    @Test
    public void testGetSalarySumByDepartment() {
        Employee employee1 = new Employee("John", "Doe", 5000, 1);
        Employee employee2 = new Employee("Jane", "Smith", 6000, 2);
        Employee employee3 = new Employee("Mike", "Johnson", 4500, 1);

        when(employeeService.getEmployeeMap()).thenReturn(Map.of(
                "JohnDoe", employee1,
                "JaneSmith", employee2,
                "MikeJohnson", employee3
        ));

        double expectedSum = 9500;
        double actualSum = departmentService.getSalarySumByDepartment(1);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testGetMaxSalaryByDepartment() {
        Employee employee1 = new Employee("John", "Doe", 5000, 1);
        Employee employee2 = new Employee("Jane", "Smith", 6000, 2);
        Employee employee3 = new Employee("Mike", "Johnson", 4500, 1);

        when(employeeService.getEmployeeMap()).thenReturn(Map.of(
                "JohnDoe", employee1,
                "JaneSmith", employee2,
                "MikeJohnson", employee3
        ));

        double expectedMaxSalary = 6000;
        double actualMaxSalary = departmentService.getMaxSalaryByDepartment(2);

        assertEquals(expectedMaxSalary, actualMaxSalary);
    }

    @Test
    public void testGetMinSalaryByDepartment() {
        Employee employee1 = new Employee("John", "Doe", 5000, 1);
        Employee employee2 = new Employee("Jane", "Smith", 6000, 2);
        Employee employee3 = new Employee("Mike", "Johnson", 4500, 1);

        when(employeeService.getEmployeeMap()).thenReturn(Map.of(
                "JohnDoe", employee1,
                "JaneSmith", employee2,
                "MikeJohnson", employee3
        ));

        double expectedMinSalary = 4500;
        double actualMinSalary = departmentService.getMinSalaryByDepartment(1);

        assertEquals(expectedMinSalary, actualMinSalary);
    }

    @Test
    public void testGetAllEmployeesGroupedByDepartment() {
        Employee employee1 = new Employee("John", "Doe", 5000, 1);
        Employee employee2 = new Employee("Jane", "Smith", 6000, 2);
        Employee employee3 = new Employee("Mike", "Johnson", 4500, 1);

        when(employeeService.getEmployeeMap()).thenReturn(Map.of(
                "JohnDoe", employee1,
                "JaneSmith", employee2,
                "MikeJohnson", employee3
        ));

        Map<Integer, List<Employee>> expectedEmployees = Map.of(
                1, Arrays.asList(employee1, employee3),
                2, Collections.singletonList(employee2)
        );
        Map<Integer, List<Employee>> actualEmployees = departmentService.getAllEmployeesGroupedByDepartment();
        assertEquals(expectedEmployees, actualEmployees);
    }
}
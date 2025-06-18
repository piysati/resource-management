package com.apexon.BenchMarkDemo.service;

import com.apexon.BenchMarkDemo.entity.Department;
import com.apexon.BenchMarkDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee getEmployee(int id);
    List<Employee> getAllEmployee();
    Employee updateEmployee(int id, Employee employee);
    void deleteEmployee(int id);
}

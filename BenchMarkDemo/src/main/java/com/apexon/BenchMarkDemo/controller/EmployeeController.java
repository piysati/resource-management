package com.apexon.BenchMarkDemo.controller;

import com.apexon.BenchMarkDemo.entity.Employee;
import com.apexon.BenchMarkDemo.repository.EmployeeRepo;
import com.apexon.BenchMarkDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping(value = "/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    @GetMapping(value = "/")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @PutMapping(value = "/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping(value = "/")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }
}

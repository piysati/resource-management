package com.apexon.BenchMarkDemo.service;

import com.apexon.BenchMarkDemo.entity.Department;
import com.apexon.BenchMarkDemo.entity.Employee;
import com.apexon.BenchMarkDemo.repository.DepartmentRepo;
import com.apexon.BenchMarkDemo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public Employee addEmployee(Employee employee) {
        int depId = employee.getDepartment().getId();
        Department department = departmentRepo.findById(depId)
                .orElseThrow(() -> new RuntimeException("Department not found: " + depId));

        employee.setDepartment(department);
        return employeeRepo.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepo.findById(id).get();
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Optional<Employee> currentEmp = employeeRepo.findById(id);
        if(currentEmp.isPresent()){
            Employee updatedEmp = currentEmp.get();
            updatedEmp.setFirst_Name(employee.getFirst_Name());
            updatedEmp.setLast_Name(employee.getLast_Name());
            updatedEmp.setDepartment(departmentRepo.findById(employee.department.id).orElseThrow());
            updatedEmp.setSalary(employee.getSalary());
            updatedEmp.setProjects(employee.getProjects());

            return employeeRepo.save(updatedEmp);
        }
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepo.deleteById(id);
    }
}

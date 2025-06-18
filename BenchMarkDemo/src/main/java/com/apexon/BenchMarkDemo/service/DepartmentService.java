package com.apexon.BenchMarkDemo.service;

import com.apexon.BenchMarkDemo.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department createDepartment(Department department);
    Department getDepartment(int id);
    List<Department> getAllDepartment();
    Department updateDepartment(int id, Department department);
    void deleteDepartment(int id);

}

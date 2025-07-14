package com.apexon.BenchMarkDemo.service;

import com.apexon.BenchMarkDemo.dto.EmployeeRequestDTO;
import com.apexon.BenchMarkDemo.dto.EmployeeResponseDTO;
import com.apexon.BenchMarkDemo.entity.Department;
import com.apexon.BenchMarkDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDTO addEmployee(EmployeeRequestDTO employee);
    EmployeeResponseDTO getEmployee(int id);
    List<EmployeeResponseDTO> getAllEmployee();
    EmployeeResponseDTO updateEmployee(int id, EmployeeRequestDTO employee);
    void deleteEmployee(int id);
}

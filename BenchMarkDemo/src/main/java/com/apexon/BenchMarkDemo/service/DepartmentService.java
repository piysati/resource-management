package com.apexon.BenchMarkDemo.service;

import com.apexon.BenchMarkDemo.dto.DepartmentRequestDTO;
import com.apexon.BenchMarkDemo.dto.DepartmentResponseDTO;
import com.apexon.BenchMarkDemo.entity.Department;

import java.util.List;

public interface DepartmentService {
    DepartmentResponseDTO createDepartment(DepartmentRequestDTO departmentRequestDTO);
    DepartmentResponseDTO getDepartment(int id);
    List<DepartmentResponseDTO> getAllDepartment();
    DepartmentResponseDTO updateDepartment(int id, DepartmentRequestDTO department);
    void deleteDepartment(int id);
}

package com.apexon.BenchMarkDemo.mapper;

import com.apexon.BenchMarkDemo.dto.DepartmentRequestDTO;
import com.apexon.BenchMarkDemo.dto.DepartmentResponseDTO;
import com.apexon.BenchMarkDemo.entity.Department;
import com.apexon.BenchMarkDemo.entity.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentMapper {
    public static DepartmentResponseDTO toResponseDTO(Department department) {
        DepartmentResponseDTO dto = new DepartmentResponseDTO();
        dto.setId(department.getId());
        dto.setName(department.getName());

//        List<Integer> employeeIds = department.getEmployees().stream()
//                .map(Employee::getId)
//                .collect(Collectors.toList());
        return dto;
    }

    public static Department toEntity(DepartmentRequestDTO dto) {
        Department department = new Department();
        department.setName(dto.getName());
        return department;
    }
}

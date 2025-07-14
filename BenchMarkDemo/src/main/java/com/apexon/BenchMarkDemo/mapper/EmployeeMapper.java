package com.apexon.BenchMarkDemo.mapper;

import com.apexon.BenchMarkDemo.dto.EmployeeRequestDTO;
import com.apexon.BenchMarkDemo.dto.EmployeeResponseDTO;
import com.apexon.BenchMarkDemo.dto.ProjectSummaryDTO;
import com.apexon.BenchMarkDemo.entity.Department;
import com.apexon.BenchMarkDemo.entity.Employee;
import com.apexon.BenchMarkDemo.entity.Project;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMapper {

    public static EmployeeResponseDTO toResponseDTO(Employee employee) {
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setId(employee.getId());
        dto.setFirst_Name(employee.getFirst_Name());
        dto.setLast_Name(employee.getLast_Name());
        dto.setSalary(employee.getSalary());
        dto.setDepartmentName(employee.getDepartment().getName());

        List<ProjectSummaryDTO> projectDTOs = employee.getProjects().stream().map(project -> {
            ProjectSummaryDTO pdto = new ProjectSummaryDTO();
            pdto.setId(project.getId());
            pdto.setTitle(project.getTitle());
            return pdto;
        }).collect(Collectors.toList());

        dto.setProjects(projectDTOs);
        return dto;
    }

    public static Employee toEntity(EmployeeRequestDTO dto, Department department, List<Project> projects) {
        Employee employee = new Employee();
        employee.setFirst_Name(dto.getFirst_Name());
        employee.setLast_Name(dto.getLast_Name());
        employee.setSalary(dto.getSalary());
        employee.setDepartment(department);
        employee.setProjects(projects);
        return employee;
    }
}

package com.apexon.BenchMarkDemo.mapper;

import com.apexon.BenchMarkDemo.dto.EmployeeSummaryDTO;
import com.apexon.BenchMarkDemo.dto.ProjectRequestDTO;
import com.apexon.BenchMarkDemo.dto.ProjectResponseDTO;
import com.apexon.BenchMarkDemo.entity.Employee;
import com.apexon.BenchMarkDemo.entity.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectMapper {

    public static ProjectResponseDTO toResponseDTO(Project project) {
        ProjectResponseDTO dto = new ProjectResponseDTO();
        dto.setId(project.getId());
        dto.setTitle(project.getTitle());
        dto.setStart_date(project.getStart_date());
        dto.setEnd_date(project.getEnd_date());
        dto.setBudget(project.getBudget());

        List<EmployeeSummaryDTO> employeeDTOs = project.getEmployees().stream().map(emp -> {
            EmployeeSummaryDTO edto = new EmployeeSummaryDTO();
            edto.setId(emp.getId());
            edto.setFullName(emp.getFirst_Name() + " " + emp.getLast_Name());
            return edto;
        }).collect(Collectors.toList());

        dto.setEmployeeSummary(employeeDTOs);
        return dto;
    }

    public static Project toEntity(ProjectRequestDTO dto) {
        Project project = new Project();
        project.setTitle(dto.getTitle());
        project.setStart_date(dto.getStart_date());
        project.setEnd_date(dto.getEnd_date());
        project.setBudget(dto.getBudget());
        project.setEmployees(new ArrayList<>());
        return project;
    }
}


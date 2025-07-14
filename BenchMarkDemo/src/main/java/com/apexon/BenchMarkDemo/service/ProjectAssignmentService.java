package com.apexon.BenchMarkDemo.service;

import com.apexon.BenchMarkDemo.dto.EmployeeResponseDTO;
import com.apexon.BenchMarkDemo.dto.ProjectResponseDTO;
import com.apexon.BenchMarkDemo.entity.Employee;
import com.apexon.BenchMarkDemo.entity.Project;
import com.apexon.BenchMarkDemo.mapper.EmployeeMapper;
import com.apexon.BenchMarkDemo.mapper.ProjectMapper;
import com.apexon.BenchMarkDemo.repository.EmployeeRepo;
import com.apexon.BenchMarkDemo.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectAssignmentService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ProjectRepo projectRepo;

    public EmployeeResponseDTO assignProjects(int employeeId, List<Integer> projectIds) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        List<Project> projects = projectRepo.findAllById(projectIds);
        employee.setProjects(projects);

        Employee updated = employeeRepo.save(employee);
        return EmployeeMapper.toResponseDTO(updated);
    }

    public List<ProjectResponseDTO> getProjectsOfEmployee(int employeeId) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        return employee.getProjects().stream()
                .map(ProjectMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public void removeProjectFromEmployee(int employeeId, int projectId) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.getProjects().removeIf(p -> p.getId() == projectId);
        employeeRepo.save(employee);
    }
}


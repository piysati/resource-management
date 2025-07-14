package com.apexon.BenchMarkDemo.controller;

import com.apexon.BenchMarkDemo.dto.EmployeeResponseDTO;
import com.apexon.BenchMarkDemo.dto.ProjectAssignmentDTO;
import com.apexon.BenchMarkDemo.dto.ProjectResponseDTO;
import com.apexon.BenchMarkDemo.service.ProjectAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees/{employeeId}/projects")
public class ProjectAssignmentController {

    @Autowired
    private ProjectAssignmentService assignmentService;

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> assignProjects(
            @PathVariable int employeeId,
            @RequestBody ProjectAssignmentDTO dto
    ) {
        return ResponseEntity.ok(assignmentService.assignProjects(employeeId, dto.getProjectIds()));
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponseDTO>> getProjects(@PathVariable int employeeId) {
        return ResponseEntity.ok(assignmentService.getProjectsOfEmployee(employeeId));
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> removeProject(@PathVariable int employeeId, @PathVariable int projectId) {
        assignmentService.removeProjectFromEmployee(employeeId, projectId);
        return ResponseEntity.noContent().build();
    }
}


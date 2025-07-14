package com.apexon.BenchMarkDemo.service;

import com.apexon.BenchMarkDemo.dto.ProjectRequestDTO;
import com.apexon.BenchMarkDemo.dto.ProjectResponseDTO;
import com.apexon.BenchMarkDemo.entity.Project;
import com.apexon.BenchMarkDemo.mapper.ProjectMapper;
import com.apexon.BenchMarkDemo.repository.ProjectRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProjectServiceImpl implements ProjectService {

    private ProjectRepo projectRepo;

    @Override
    public ProjectResponseDTO createProject(ProjectRequestDTO dto) {
        if (projectRepo.existsByTitle(dto.title)) {
            throw new RuntimeException("Project with this title already exists");
        }

        Project project = ProjectMapper.toEntity(dto);
        Project saved = projectRepo.save(project);
        return ProjectMapper.toResponseDTO(saved);
    }

    @Override
    public ProjectResponseDTO getProjectById(Integer id) {
        Project project = projectRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        return ProjectMapper.toResponseDTO(project);
    }

    @Override
    public List<ProjectResponseDTO> getAllProjects() {
        return projectRepo.findAll().stream()
                .map(ProjectMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectResponseDTO updateProject(Integer id, ProjectRequestDTO dto) {
        Project project = projectRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        project.title = dto.title;
        project.start_date = dto.start_date;
        project.end_date = dto.end_date;
        project.budget = dto.budget;

        return ProjectMapper.toResponseDTO(projectRepo.save(project));
    }

    @Override
    public void deleteProject(Integer id) {
        if (!projectRepo.existsById(id)) {
            throw new RuntimeException("Project not found");
        }
        projectRepo.deleteById(id);
    }
}

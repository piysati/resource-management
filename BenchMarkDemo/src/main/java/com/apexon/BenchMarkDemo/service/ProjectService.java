package com.apexon.BenchMarkDemo.service;

import com.apexon.BenchMarkDemo.dto.ProjectRequestDTO;
import com.apexon.BenchMarkDemo.dto.ProjectResponseDTO;
import com.apexon.BenchMarkDemo.entity.Project;
import java.util.List;

public interface ProjectService {

    ProjectResponseDTO createProject(ProjectRequestDTO dto);
    ProjectResponseDTO getProjectById(Integer id);
    List<ProjectResponseDTO> getAllProjects();
    ProjectResponseDTO updateProject(Integer id, ProjectRequestDTO dto);
    void deleteProject(Integer id);

}

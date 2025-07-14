package com.apexon.BenchMarkDemo.service;

import com.apexon.BenchMarkDemo.dto.EmployeeRequestDTO;
import com.apexon.BenchMarkDemo.dto.EmployeeResponseDTO;
import com.apexon.BenchMarkDemo.entity.Department;
import com.apexon.BenchMarkDemo.entity.Employee;
import com.apexon.BenchMarkDemo.entity.Project;
import com.apexon.BenchMarkDemo.mapper.EmployeeMapper;
import com.apexon.BenchMarkDemo.repository.DepartmentRepo;
import com.apexon.BenchMarkDemo.repository.EmployeeRepo;
import com.apexon.BenchMarkDemo.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private ProjectRepo projectRepo;

//    public EmployeeResponseDTO assignProjects(int employeeId, List<Integer> projectIds) {
//        Employee employee = employeeRepo.findById(employeeId)
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//
//        List<Project> projects = projectRepo.findAllById(projectIds);
//
//        if (projects.size() != projectIds.size()) {
//            throw new RuntimeException("One or more projects not found");
//        }
//
//        employee.setProjects(projects); // or use addAll(projects) if appending
//        return employeeRepo.save(employee);
//    }

    @Override
    public EmployeeResponseDTO addEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Department department = departmentRepo.findByName(employeeRequestDTO.getDepartmentName())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        //assign projects using service
//        List<Project> projects = projectRepo.findAllById(employeeRequestDTO.getProjectIds());

        Employee employee = EmployeeMapper.toEntity(employeeRequestDTO, department, new ArrayList<>());
        Employee saved = employeeRepo.save(employee);

        return EmployeeMapper.toResponseDTO(saved);
    }

    @Override
    public EmployeeResponseDTO getEmployee(int id) {
        Employee emp = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        return EmployeeMapper.toResponseDTO(emp);
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployee() {
        return employeeRepo.findAll().stream().map(EmployeeMapper::toResponseDTO).toList();
    }

    @Override
    public EmployeeResponseDTO updateEmployee(int id, EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Department department = departmentRepo.findByName(employeeRequestDTO.getDepartmentName())
                .orElseThrow(() -> new RuntimeException("Department not found"));

//        List<Project> projects = projectRepo.findAllById(employeeRequestDTO.getProjectIds());
        List<Project> projects = null;

        employee.setFirst_Name(employeeRequestDTO.getFirst_Name());
        employee.setLast_Name(employeeRequestDTO.getLast_Name());
        employee.setSalary(employeeRequestDTO.getSalary());
        employee.setDepartment(department);
        employee.setProjects(new ArrayList<>());

        return EmployeeMapper.toResponseDTO(employeeRepo.save(employee));
    }

    @Override
    public void deleteEmployee(int id) {
        if (!employeeRepo.existsById(id)) {
            throw new RuntimeException("Employee not found");
        }
        employeeRepo.deleteById(id);
    }
}
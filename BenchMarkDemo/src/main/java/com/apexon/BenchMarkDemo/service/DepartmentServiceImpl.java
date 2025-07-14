package com.apexon.BenchMarkDemo.service;

import com.apexon.BenchMarkDemo.dto.DepartmentRequestDTO;
import com.apexon.BenchMarkDemo.dto.DepartmentResponseDTO;
import com.apexon.BenchMarkDemo.entity.Department;
import com.apexon.BenchMarkDemo.mapper.DepartmentMapper;
import com.apexon.BenchMarkDemo.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO departmentRequestDTO) {
        if(departmentRepo.existsByName(departmentRequestDTO.getName())){
            throw new RuntimeException("Department already exists");
        }

        Department department = DepartmentMapper.toEntity(departmentRequestDTO);
        Department savedDepartment = departmentRepo.save(department);

        return DepartmentMapper.toResponseDTO(savedDepartment);
    }

    @Override
    public DepartmentResponseDTO getDepartment(int id) {
        Department dept = departmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No department found with this id"));
        return DepartmentMapper.toResponseDTO(dept);
    }

    @Override
    public List<DepartmentResponseDTO> getAllDepartment() {
        return departmentRepo.findAll().stream().map(DepartmentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentResponseDTO updateDepartment(int id, DepartmentRequestDTO departmentRequestDTO) {
        Department dept = departmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No department found with this id"));
        dept.setName(departmentRequestDTO.getName());

//        Optional<Department> currentDepartment = departmentRepo.findById(id);
//        if(currentDepartment.isPresent()){
//            Department dep = currentDepartment.get();
//            dep.setName(department.getName());
//            dep.setEmployees(department.getEmployees());
//
//            return departmentRepo.save(dep);
//        }
        return DepartmentMapper.toResponseDTO(departmentRepo.save(dept));
    }

    @Override
    public void deleteDepartment(int id) {
//        Optional<Department> currentDepartment = departmentRepo.findById(id);
//        if(currentDepartment.isPresent()){
//            Department dep = currentDepartment.get();
//            dep.setName(department.getName());
//            dep.setEmployees(department.getEmployees());
//
//            departmentRepo.delete(dep);
//        }
        if(!departmentRepo.existsById(id)){
            throw new RuntimeException("No Department found with this id");
        }
        departmentRepo.deleteById(id);
    }
}

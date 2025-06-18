package com.apexon.BenchMarkDemo.service;

import com.apexon.BenchMarkDemo.entity.Department;
import com.apexon.BenchMarkDemo.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public Department createDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public Department getDepartment(int id) {
        return departmentRepo.findById(id).get();
        //.orElseNull()
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepo.findAll();
    }

    @Override
    public Department updateDepartment(int id, Department department) {
        Optional<Department> currentDepartment = departmentRepo.findById(id);
        if(currentDepartment.isPresent()){
            Department dep = currentDepartment.get();
            dep.setName(department.getName());
            dep.setEmployees(department.getEmployees());

            return departmentRepo.save(dep);
        }
        return departmentRepo.save(department);
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
        departmentRepo.deleteById(id);
    }
}

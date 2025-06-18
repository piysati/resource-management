package com.apexon.BenchMarkDemo.controller;

import com.apexon.BenchMarkDemo.entity.Department;
import com.apexon.BenchMarkDemo.service.DepartmentService;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/test")
    public String test(){
        return  "Test";
    }

    @PostMapping(value = "/")
    public Department createDepartment(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }

    @GetMapping(value = "/{id}")
    public Department getDepartment(@PathVariable int id){
        return departmentService.getDepartment(id);
    }

    @GetMapping(value = "/")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    @PutMapping(value = "/{id}")
    public Department updateDepartment(@PathVariable int id, @RequestBody Department department){
        return departmentService.updateDepartment(id, department);

    }

    @DeleteMapping(value = "/{id}")
    public void deleteDepartment(@PathVariable int id){
        departmentService.deleteDepartment(id);
    }
}

package com.apexon.BenchMarkDemo.controller;

import com.apexon.BenchMarkDemo.dto.DepartmentRequestDTO;
import com.apexon.BenchMarkDemo.dto.DepartmentResponseDTO;
import com.apexon.BenchMarkDemo.entity.Department;
import com.apexon.BenchMarkDemo.service.DepartmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<DepartmentResponseDTO> createDepartment(@Valid @RequestBody DepartmentRequestDTO departmentRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(departmentService.createDepartment(departmentRequestDTO));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentResponseDTO> getDepartment(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.getDepartment(id));
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartment(){
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.getAllDepartment());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DepartmentResponseDTO> updateDepartment(@PathVariable int id, @Valid @RequestBody DepartmentRequestDTO departmentRequestDTO){
        return ResponseEntity.status(HttpStatus.OK)
                .body(departmentService.updateDepartment(id, departmentRequestDTO));

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable int id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}

package com.apexon.BenchMarkDemo.controller;

import com.apexon.BenchMarkDemo.dto.EmployeeRequestDTO;
import com.apexon.BenchMarkDemo.dto.EmployeeResponseDTO;
import com.apexon.BenchMarkDemo.entity.Employee;
import com.apexon.BenchMarkDemo.repository.EmployeeRepo;
import com.apexon.BenchMarkDemo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/")
    public ResponseEntity<EmployeeResponseDTO> addEmployee(@RequestBody @Valid EmployeeRequestDTO employeeRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(employeeRequestDTO));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployee(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployee(id));
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployee());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(@PathVariable int id, @RequestBody @Valid EmployeeRequestDTO employeeRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(id, employeeRequestDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}

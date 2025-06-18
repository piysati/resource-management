package com.apexon.BenchMarkDemo.repository;

import com.apexon.BenchMarkDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}

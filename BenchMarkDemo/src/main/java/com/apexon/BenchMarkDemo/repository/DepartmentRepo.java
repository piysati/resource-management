package com.apexon.BenchMarkDemo.repository;

import com.apexon.BenchMarkDemo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}

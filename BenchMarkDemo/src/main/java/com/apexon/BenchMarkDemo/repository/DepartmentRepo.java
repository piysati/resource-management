package com.apexon.BenchMarkDemo.repository;

import com.apexon.BenchMarkDemo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
    boolean existsByName(String name);
    Optional<Department> findByName(String name);
}

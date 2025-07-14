package com.apexon.BenchMarkDemo.repository;

import com.apexon.BenchMarkDemo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Integer> {
    boolean existsByTitle(String title);
}

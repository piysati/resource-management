package com.apexon.BenchMarkDemo.dto;

import jakarta.validation.constraints.NotBlank;

public class DepartmentRequestDTO {
    @NotBlank(message = "Department name is required")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

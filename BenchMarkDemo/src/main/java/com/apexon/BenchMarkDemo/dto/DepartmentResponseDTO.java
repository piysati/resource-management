package com.apexon.BenchMarkDemo.dto;

import java.util.List;

public class DepartmentResponseDTO {
    private int id;
    private String name;
    private List<Integer> employeeIds; // Optional: if you want to show associated employees

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(List<Integer> employeeIds) {
        this.employeeIds = employeeIds;
    }
}

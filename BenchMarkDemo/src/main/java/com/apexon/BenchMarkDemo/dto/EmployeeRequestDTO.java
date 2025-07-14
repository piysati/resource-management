package com.apexon.BenchMarkDemo.dto;



import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.List;

public class EmployeeRequestDTO {
    @NotBlank(message = "First name is required")
    public String first_Name;
    @NotBlank(message = "Last name is required")
    public String last_Name;
    @DecimalMin(value = "0.00", inclusive = true, message = "Salary must be a non-negative number")
    @Digits(integer = 10, fraction = 2, message = "Salary can have up to 2 decimal places")
    public BigDecimal salary;
    @NotBlank(message = "Department name is required")
    public String departmentName;

//    private List<Integer> projectIds; // Optional: assign projects during creation


    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

//    public List<Integer> getProjectIds() {
//        return projectIds;
//    }
//
//    public void setProjectIds(List<Integer> projectIds) {
//        this.projectIds = projectIds;
//    }
}

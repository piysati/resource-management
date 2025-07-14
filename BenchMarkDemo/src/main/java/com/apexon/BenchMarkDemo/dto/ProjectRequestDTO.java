package com.apexon.BenchMarkDemo.dto;

import java.time.LocalDate;
import java.util.List;

public class ProjectRequestDTO {
    public String title;
    public LocalDate start_date;
    public LocalDate end_date;
    public Integer budget;
//    public List<Integer> employeeId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

//    public List<Integer> getEmployees() {
//        return employeeId;
//    }
//
//    public void setEmployees(List<Integer> employees) {
//        this.employeeId = employees;
//    }
}

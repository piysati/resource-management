package com.apexon.BenchMarkDemo.dto;

import java.time.LocalDate;
import java.util.List;

public class ProjectResponseDTO {
    public int id;
    public String title;
    public LocalDate start_date;
    public LocalDate end_date;
    public Integer budget;
    public List<EmployeeSummaryDTO> employeeSummary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public List<EmployeeSummaryDTO> getEmployeeSummary() {
        return employeeSummary;
    }

    public void setEmployeeSummary(List<EmployeeSummaryDTO> employeeSummary) {
        this.employeeSummary = employeeSummary;
    }
}

package com.bl.domain;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "employee")
public class EmployeePayroll implements Serializable {

    private static final long serialVersionUID = -8900492704842756948L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;
    private String salary;
    private String gender;
    private String department;
    private String startDate;

    public EmployeePayroll(){

    }

    public EmployeePayroll(@NonNull String name, String salary, String gender, String department, String startDate) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.department = department;
        this.startDate = startDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}

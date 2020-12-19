package com.bl.dto;


import com.bl.domain.EmployeePayroll;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@Getter
@Setter
@JsonIgnoreProperties
public class EmployeePayrollDto {
    private Long id;

    @NotNull(message = "Name cannot be null!")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Employee Name Invalid!")
    private String name;

    @NotNull(message = "Salary cannot be null!")
    @Min(value = 500, message = "Min Wage Should Be More Than 500!")
    private String salary;

    @NotNull(message = "Gender cannot be null!")
    @NotEmpty(message = "Gender Can't Be Empty!")
    private String gender;

    @NotNull(message = "Department cannot be null!")
    @NotEmpty(message = "Department Can't Be Empty!")
    private List<String> department;

    @NotNull(message = "Start Date cannot be null!")
    @NotEmpty(message = "Start Date Can't Be Empty!")
    private String startDate;

    private String notes;

    @NotNull(message = "Profile pic cannot be null!")
    private String profile;

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

    public List<String> getDepartment() {
        return department;
    }

    public void setDepartment(List<String> department) {
        this.department = department;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public EmployeePayrollDto(){

    }

    public EmployeePayrollDto(EmployeePayroll user){
        this.id = user.getId();
        this.name = user.getName();
        this.salary = user.getSalary();
        this.gender = user.getGender();
        this.department = user.getDepartment();
        this.startDate = user.getStartDate();
        this.notes = user.getNotes();
        this.profile = user.getProfile();
    }

    @Override
    public String toString() {
        return "EmployeePayrollDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", gender='" + gender + '\'' +
                ", department=" + department +
                ", startDate='" + startDate + '\'' +
                ", notes='" + notes + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}

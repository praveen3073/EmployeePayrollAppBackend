package com.bl.dto;


import com.bl.domain.EmployeePayroll;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@Getter
@Setter
public class EmployeePayrollDto {
    private Long id;

    @Pattern(regexp = "^[A-Z][a-zA-z\\s]{2,}$", message = "Employee Name Invalid!")
    private String name;
    @Min(value = 500, message = "Min Wage Should Be More Than 500!")
    private String salary;
    @NotEmpty(message = "Gender Can't Be Empty!")
    private String gender;
    @NotEmpty(message = "Department Can't Be Empty!")
    private String department;
    @NotEmpty(message = "Start Date Can't Be Empty!")
    private String startDate;

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

    public EmployeePayrollDto(){

    }

    public EmployeePayrollDto(EmployeePayroll user){
        this.id = user.getId();
        this.name = user.getName();
        this.salary = user.getSalary();
        this.gender = user.getGender();
        this.department = user.getDepartment();
        this.startDate = user.getStartDate();
    }
}

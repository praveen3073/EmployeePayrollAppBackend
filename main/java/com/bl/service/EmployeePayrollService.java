package com.bl.service;

import com.bl.domain.EmployeePayroll;
import com.bl.dto.EmployeePayrollDto;
import com.bl.exceptions.DetailsNotProvidedExceptions;
import com.bl.exceptions.UserNotFoundException;
import com.bl.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    public EmployeePayrollDto CreateUser(EmployeePayrollDto employeePayrollDto){
        if(Objects.nonNull(employeePayrollDto.getName()) &&
                Objects.nonNull(employeePayrollDto.getSalary()) &&
                Objects.nonNull(employeePayrollDto.getDepartment()) &&
                Objects.nonNull(employeePayrollDto.getGender()) &&
                Objects.nonNull(employeePayrollDto.getStartDate())) {
            EmployeePayroll employeePayroll = new EmployeePayroll(employeePayrollDto.getName(),
                                                                    employeePayrollDto.getSalary(),
                                                                    employeePayrollDto.getGender(),
                                                                    employeePayrollDto.getDepartment(),
                                                                    employeePayrollDto.getStartDate(),
                                                                    employeePayrollDto.getNotes(),
                                                                    employeePayrollDto.getProfile());
            return new EmployeePayrollDto(employeePayrollRepository.save(employeePayroll));
        }

            throw new DetailsNotProvidedExceptions("Input Fields Can't Be Null!");
    }

    public EmployeePayrollDto UpdateUser(EmployeePayrollDto employeePayrollDto){

        return employeePayrollRepository.findById(employeePayrollDto.getId()).map(employeePayroll -> {
            if(Objects.nonNull(employeePayrollDto.getName())){
                employeePayroll.setName(employeePayrollDto.getName());
            }
            if(Objects.nonNull(employeePayrollDto.getSalary())){
                employeePayroll.setSalary(employeePayrollDto.getSalary());
            }
            if(Objects.nonNull(employeePayrollDto.getDepartment())){
                employeePayroll.setDepartment(employeePayrollDto.getDepartment());
            }
            if(Objects.nonNull(employeePayrollDto.getGender())){
                employeePayroll.setGender(employeePayrollDto.getGender());
            }
            if(Objects.nonNull(employeePayrollDto.getStartDate())){
                employeePayroll.setStartDate(employeePayrollDto.getStartDate());
            }
            if(Objects.nonNull(employeePayrollDto.getNotes())){
                employeePayroll.setNotes(employeePayrollDto.getNotes());
            }
            if(Objects.nonNull(employeePayrollDto.getProfile())){
                employeePayroll.setProfile(employeePayrollDto.getProfile());
            }
           return new EmployeePayrollDto(employeePayrollRepository.save(employeePayroll));
        }).orElseThrow(()-> new UserNotFoundException("User Not Found!"));
    }

    public EmployeePayrollDto deleteUser(Long id){
        return employeePayrollRepository.findById(id).map(employeePayroll -> {
            employeePayrollRepository.deleteById(employeePayroll.getId());
            return new EmployeePayrollDto(employeePayroll);
        }).orElseThrow(()-> new UserNotFoundException("User Not Found!"));
    }


    public List<EmployeePayrollDto> getAllUser(){
        return employeePayrollRepository.findAll()
                .stream()
                .map(employeePayroll -> new EmployeePayrollDto(employeePayroll))
                .collect(Collectors.toList());
    }

    public Optional<EmployeePayroll> getUser(Long id) {
        return employeePayrollRepository.findById(id);
    }
}

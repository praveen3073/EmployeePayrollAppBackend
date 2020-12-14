package com.bl.controller;

import com.bl.dto.EmployeePayrollDto;
import com.bl.dto.ResponseDto;
import com.bl.exceptions.PayrollException;
import com.bl.exceptions.UserNotFoundException;
import com.bl.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {

    @Autowired
    EmployeePayrollService employeePayrollService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createUser(@Valid @RequestBody EmployeePayrollDto user){
        ResponseDto responseDto = new ResponseDto("Employee Record Created Succesfully", employeePayrollService.CreateUser(user));
            return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateUser(@Valid @RequestBody EmployeePayrollDto user){
        ResponseDto responseDto = new ResponseDto("Employee Record Updated Succesfully", employeePayrollService.UpdateUser(user));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable("id")Long id){
        ResponseDto responseDto = new ResponseDto("Employee Record Deleted Succesfully", employeePayrollService.deleteUser(id));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getAllUser(){
        ResponseDto responseDto = new ResponseDto("Displaying All Records in DB", employeePayrollService.getAllUser());
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}

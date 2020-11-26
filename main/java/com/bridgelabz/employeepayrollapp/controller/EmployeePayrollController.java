package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.model.EmployeeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayrollController {
    @GetMapping("/employee")
    public ResponseEntity<String> getEmployeeData() {
        return new ResponseEntity<String>("Get Response from server"
                , HttpStatus.OK);
    }

    @GetMapping("/getid/{empId}")
    public ResponseEntity<String> getEmployeeId(@PathVariable(value="empId") int empId) {
        return new ResponseEntity<String>("Get Response from server" + empId, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<String>("Get the Response from post request " + employeeDTO.toString(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<String>("Get the Response from put request " + employeeDTO.toString(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(value="empId") int empId) {
        return new ResponseEntity<String>("Get the Response from delete request " + empId, HttpStatus.OK);
    }
}

package com.bl.exceptions;

import com.bl.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
//@Slf4j
public class EmployeeGlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errorMessage = errorList.stream()
                .map(objErr -> objErr.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDto responseDto = new ResponseDto("Exception while processing REST Request", errorMessage);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseDto> handleUserNotFoundException(
                UserNotFoundException exception) {
        ResponseDto responseDto = new ResponseDto("Exception while processing REST Request", exception.getMessage());
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DetailsNotProvidedExceptions.class)
    public ResponseEntity<ResponseDto> handleDetailsNotProvidedExceptions(
            DetailsNotProvidedExceptions exception) {
        ResponseDto responseDto = new ResponseDto("Exception while processing REST Request", exception.getMessage());
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(PayrollException.class)
    public ResponseEntity<ResponseDto> handleException(PayrollException payrollException) {
        return new ResponseEntity<ResponseDto>(new ResponseDto(null, payrollException.exceptionTypes.errorMessage),
                HttpStatus.BAD_REQUEST);
    }
}

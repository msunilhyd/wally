package com.interview.employee.service.Exception;

import org.springframework.http.HttpStatus;
import com.interview.employee.service.entity.ErrorMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorMessage handleException(EmployeeNotFoundException ex) {
        return new ErrorMessage(HttpStatus.METHOD_NOT_ALLOWED, ex.getMessage());
    }
}

package com.cpyproj1.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// Step 16 - Create a DepartmentNotFoundException class
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cpyproj1.demo.entities.ErrorMassage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMassage> departmentNotFoundException(DepartmentNotFoundException ex, WebRequest request) {
        
        ErrorMassage msg = new ErrorMassage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }

    
    
}

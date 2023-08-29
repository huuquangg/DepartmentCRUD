package com.cpyproj1.demo.entities;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class ErrorMassage {
    private HttpStatus status;
    private String message;
    

}

package com.cpyproj1.demo.exception;


// Step 16 - Create a DepartmentNotFoundException class

public class DepartmentNotFoundException extends Exception{
    // Override all Exception class's constructors
    
    public DepartmentNotFoundException() {
        super();
    }

    public DepartmentNotFoundException(String message) {
        super(message);
    }

    public DepartmentNotFoundException(Throwable cause) {
        super(cause);
    }

    public DepartmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    protected DepartmentNotFoundException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }



}

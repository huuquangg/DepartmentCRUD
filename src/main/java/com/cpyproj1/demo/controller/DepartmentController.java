package com.cpyproj1.demo.controller;
// Step4 - Create a DepartmentController class

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.cpyproj1.demo.entities.Department;
import com.cpyproj1.demo.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {
    
    // Step 7 - REST method below
    @Autowired
    private DepartmentService departmentService;

    // Step 15.1 - Logger
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    // Step 14.2 - Validation with RequestBody
    @PostMapping("/departments")//     |
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentController"); // Step 15.1 - Logger
        return departmentService.saveDepartment(department);
    }


    // Step 8.1 - REST method below - fetching to the database (standing in Controller)-> Service -> Repository
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside saveDepartment of DepartmentController"); // Step 15.1 - Logger
        return departmentService.fetchDepartmentList();
    }
    // Step 9 - USing Postman to test the REST API

    // Step 10 - Dynamic GetMapping
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentService.fetchDepartmentById(departmentId);
    }


    // Step 11.1 - DeleteMapping
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department is deleted successfully";
    }

    // Step 12.1 - UpdateMapping Update a department by id
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    // Step 13 - Endpoints fechDepartmentByName
    //http://localhost:8082/departments/name/IS
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }

}

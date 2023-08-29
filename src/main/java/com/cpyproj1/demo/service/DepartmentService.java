package com.cpyproj1.demo.service;

import java.util.List;

import com.cpyproj1.demo.entities.Department;

// Step5.1 - Create a DepartmentServiceImpl class and implement DepartmentService interface
public interface DepartmentService {

    public Department saveDepartment(Department department);

    // Step 8.2 - REST method below - fetching to the database Controller-> (Service) -> Repository
    public List<Department> fetchDepartmentList();

    // Step 10.2 - Dynamic GetMapping
    public Department fetchDepartmentById(Long departmentId);

    // Step 11.2 - DeleteMapping
    public void deleteDepartmentById(Long departmentId);

    // Step 12.2 - UpdateMapping Update a department by id
    public Department updateDepartment(Long departmentId, Department department);

    // Step 13.2 - Endpoints fechDepartmentByName
    public Department fetchDepartmentByName(String departmentName);
    
}

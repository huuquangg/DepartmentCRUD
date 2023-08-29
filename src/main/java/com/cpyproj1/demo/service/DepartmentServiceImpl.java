package com.cpyproj1.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpyproj1.demo.entities.Department;
import com.cpyproj1.demo.repository.DepartmentRepository;

// Step5.2 - Create a DepartmentServiceImpl class and implement DepartmentService interface
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Step 8.3 - REST method below - @Override Controller-> (Service->impl) -> Repository
    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    // Step 10.3 - Dynamic Get 1 particular department
    // http://localhost:8082/departments/3
    @Override
    public Department fetchDepartmentById(Long departmentId) {
        // Step 10. 3 :: 1 version: return departmentRepository.findById(departmentId).get();
        
        // step 16.1 - Exception handling 
        //version 2:
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent()) {
            throw new RuntimeException("Department not found in your database");
        }
        return department.get();
    }
    

    // Step 11.3 - DeleteMapping
    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    // Step 12.3 - UpdateMapping Update a department by id
    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();

        // check if the departmentName is not null and not empty
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDB.setDepartmentName(department.getDepartmentName());
        }
        
        // check if the departmentAddress is not null and not empty
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        // check if the departmentCode is not null and not empty
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }
        
        // save the updated department
        return departmentRepository.save(depDB);
    }

    // Step 13.3 - Endpoints fechDepartmentByName
    
    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

}

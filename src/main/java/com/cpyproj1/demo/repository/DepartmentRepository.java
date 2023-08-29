package com.cpyproj1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cpyproj1.demo.entities.Department;

// Step6 - Create a DepartmentRepository interface and extend JpaRepository !important
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    // Step 13.3 - Endpoints fechDepartmentByName
    public Department findByDepartmentName(String departmentName);
    // Step 13.4 - Endpoints fechDepartmentByName but ignore case return 1 of 2
    @Query(value = "", nativeQuery = true)
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}

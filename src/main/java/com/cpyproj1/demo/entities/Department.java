package com.cpyproj1.demo.entities;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

// Step3 - Create a Department entity
@Entity
@Data // included getter, setter, toString method => use Lombok
@AllArgsConstructor // included constructor => use Lombok
@Builder // included builder => use Lombok
public class Department {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    // Step 14.1 - Validation =))) doesn't work
    @NotBlank(message = "Please add department name (not blank))")
    @Length(max = 10, min = 2, message = "Please add department name between 2 and 10 characters")
    @Size(max = 10, min = 2, message = "Please add department name between 2 and 10 characters")
    private String departmentName;

    private String departmentAddress;
    private String departmentCode;

    Department() {
    }

    // I already delete the constructor, getter, setter, toString method => use Lombok instead


}

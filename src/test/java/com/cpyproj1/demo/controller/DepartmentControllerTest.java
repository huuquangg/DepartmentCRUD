package com.cpyproj1.demo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cpyproj1.demo.entities.Department;
import com.cpyproj1.demo.service.DepartmentService;

// Step 16 - Test the REST API Controller
@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;
    
    @BeforeEach
    void setUp() {
        department = Department.builder()
                                .departmentName("IS")
                                .departmentAddress("HCM")
                                .departmentCode("UIT-B")
                                .departmentId(1L)
                                .build();             
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                                                .departmentName("IS")
                                                .departmentAddress("HCM")
                                                .departmentCode("UIT-B")
                                                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                                              .contentType(MediaType.APPLICATION_JSON)
                                              .content("{\n" +
                                                       "    \"departmentName\": \"IS\",\n" +
                                                       "    \"departmentAddress\": \"HCM\",\n" +
                                                       "    \"departmentCode\": \"UIT-B\"\n" +
                                                       "}"))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
                                              .contentType(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName")
                                              .value(department.getDepartmentName()));

    }

}

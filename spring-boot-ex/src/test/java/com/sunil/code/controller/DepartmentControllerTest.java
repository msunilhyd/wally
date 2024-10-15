package com.sunil.code.controller;

import com.sunil.code.entity.Department;
import com.sunil.code.error.DepartmentNotFoundException;
import com.sunil.code.service.DepartmentService;
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

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setup() {
        department = Department
                .builder()
                .departmentId(8L)
                .departmentName("IT")
                .departmentCode("IT101")
                .departmentAddress("Mumbai")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department
                .builder()
                .departmentName("IT")
                .departmentCode("IT101")
                .departmentAddress("Mumbai")
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(post("/departments")
        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"departmentName\": \"IT\",\n" +
                                "    \"departmentAddress\": \"Mumbai\",\n" +
                                "    \"departmentCode\": \"IT101\"\n" +
                                "}")
        ).andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {

        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((jsonPath("$.departmentName")
                        .value(department.getDepartmentName())));
    }
}
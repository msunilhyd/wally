package com.kk.project.service;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.kk.project.entity.Department;
import com.kk.project.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .id(4)
                .name("MME")
                .address("Florida")
                .build();
    }

    @Test
    void test_findById() {
        when(departmentRepository.findById(any())).thenReturn(Optional.ofNullable(department));

        assertNotNull(departmentService.findById(any()));
    }
}
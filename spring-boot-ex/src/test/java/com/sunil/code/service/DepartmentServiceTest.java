package com.sunil.code.service;

import com.sunil.code.entity.Department;
import com.sunil.code.error.DepartmentNotFoundException;
import com.sunil.code.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @InjectMocks
    private DepartmentService departmentService;

    @Mock
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

        Department department =
                Department
                        .builder()
                        .departmentName("MME")
                        .departmentCode("MKE101")
                        .departmentAddress("Madras")
                        .departmentId(1L)
                        .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("MME")).thenReturn(Optional.ofNullable(department));
    }

    @Test
    public void whenValidDeptName_thenDeptShouldBeFound() throws DepartmentNotFoundException {
        String departmentName = "MME";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}
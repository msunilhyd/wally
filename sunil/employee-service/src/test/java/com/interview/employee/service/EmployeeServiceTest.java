package com.interview.employee.service;

import com.interview.employee.service.entity.Employee;
import com.interview.employee.service.repository.EmployeeRepository;
import com.interview.employee.service.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    void testGetEmployeeById() {
        Employee employee = new Employee(1, "sunil", "kumar", "CSE");

        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));
        Employee result = employeeService.findById(1);

        assertThat(result).isEqualTo(employee);
    }
}

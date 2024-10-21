package com.interview.employee.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void getAllEmployees() {
        ResponseEntity<Object[]> employeeList = restTemplate.getForEntity("http://localhost:" + port + "/employee/", Object[].class);

        assertThat(employeeList.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(employeeList.getBody()).isNotNull();
    }
}

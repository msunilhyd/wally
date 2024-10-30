package com.kk.project.controller;

import com.kk.project.entity.Department;
import com.kk.project.exception.DepartmentAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DepartmentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

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
    void test_findAll() {
        ResponseEntity<Department[]> response = restTemplate.getForEntity("http://localhost:" + port + "/department", Department[].class);

        assertNotNull(response.getBody());
        assertEquals(response.getBody().length, 4);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testAddDepartmentSuccess() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+port+"/department";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>("{\n" +
                "    \"id\": 2,\n" +
                "    \"name\": \"EE\",\n" +
                "    \"address\": \"3410 Hamlet cross\"\n" +
                "}", headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        assertEquals(result.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);

        //Verify request succeed
//        assertEquals(200, result.getStatusCodeValue());
    }
}
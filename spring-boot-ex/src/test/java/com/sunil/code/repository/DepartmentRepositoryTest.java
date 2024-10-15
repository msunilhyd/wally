package com.sunil.code.repository;

import com.sunil.code.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department
                .builder()
//                .departmentId(8L)
                .departmentAddress("Delhi")
                .departmentCode("EE101")
                .departmentName("Electrical Engineering")
                .build();

        entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        Department department1 = departmentRepository.save(department);
        assertThat(entityManager.find(Department.class, department1.getDepartmentId())).isEqualTo(department1);
    }
}
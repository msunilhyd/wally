package com.kk.project.controller;

import com.kk.project.entity.Department;
import com.kk.project.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> createDept(@RequestBody Department department) {
        log.info("Creating dept with name :- {}", department.getName());
        return ResponseEntity.ok(departmentService.createDepartment(department));
    }

    @GetMapping
    public ResponseEntity<List<Department>> findAll(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value= "sortBy", defaultValue = "id", required = false) String sortBy

    ) {
        return ResponseEntity.ok(departmentService.findAll(pageNo, pageSize, sortBy));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(departmentService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDept(@PathVariable int id, @RequestBody Department dept) {
       return ResponseEntity.ok(departmentService.update(id, dept));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDept(@PathVariable int id) {
        departmentService.deleteDept(id);
        return ResponseEntity.ok("Successfully deleted department with id :- " + id);
    }
}

package com.sunil.code.controller;

import com.sunil.code.entity.Department;
import com.sunil.code.error.DepartmentNotFoundException;
import com.sunil.code.error.RestResponseEntityExceptionHandler;
import com.sunil.code.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
       return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> fetchDepartmentById(@PathVariable("id") Long deptId) throws DepartmentNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(departmentService.fetchDepartmentById(deptId));
    }

    @GetMapping("/departments/name/{deptName}")
    public ResponseEntity<Department> fetchDepartmentByName(@PathVariable("deptName") String deptName) throws DepartmentNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(departmentService.fetchDepartmentByName(deptName));
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long deptId) {
        departmentService.deleteDepartmentById(deptId);
        return "Department deleted succesfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long deptId, @RequestBody Department department) {
        return departmentService.udpateDepartment(deptId, department);
    }
}

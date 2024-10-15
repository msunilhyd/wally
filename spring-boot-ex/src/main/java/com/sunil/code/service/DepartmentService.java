package com.sunil.code.service;

import com.sunil.code.entity.Department;
import com.sunil.code.error.DepartmentNotFoundException;
import com.sunil.code.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department not available with id : " + id);
        }
        return department.get();
    }


    public Department fetchDepartmentByName(String deptName) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findByDepartmentNameIgnoreCase(deptName);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department not available with department name : " + deptName);
        }
        return department.get();
    }

    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    public Department udpateDepartment(Long id, Department department) {
        Department existingDepartment = departmentRepository.findById(id).get();
        if (Objects.nonNull(department.getDepartmentName())) {
            existingDepartment.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentCode())) {
            existingDepartment.setDepartmentCode(department.getDepartmentCode());
        }
        if (Objects.nonNull(department.getDepartmentAddress())) {
            existingDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(existingDepartment);
    }
}

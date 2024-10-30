package com.kk.project.service;

import com.kk.project.entity.Department;
import com.kk.project.exception.DepartmentAlreadyExistsException;
import com.kk.project.exception.DepartmentNotFoundException;
import com.kk.project.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> findAll(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Department> pagedList =  departmentRepository.findAll(pageable);
        return pagedList.getContent();
    }

    public Department createDepartment(Department department) {
        if (!ObjectUtils.isEmpty(department.getId())) {
            Department deptDB = departmentRepository.findById(department.getId()).get();
            if (!ObjectUtils.isEmpty(deptDB)) {
               throw new DepartmentAlreadyExistsException("Department already exsits in DB with id :- " + department.getId());
            }
        }
        return departmentRepository.save(department);
    }

    public Department findById(Integer id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found with id " + id));
    }

    public Department update(int id, Department dept) {
        Department deptDB = departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found with id:- " + id));
        if (!ObjectUtils.isEmpty(dept.getName())) {
            deptDB.setName(dept.getName());
        }
        if (!ObjectUtils.isEmpty(dept.getAddress())) {
            deptDB.setAddress(dept.getAddress());
        }
        return departmentRepository.save(deptDB);
    }

    public void deleteDept(int id) {
        departmentRepository.deleteById(id);
    }
}

package com.interview.employee.service.service;

import com.interview.employee.service.Exception.EmployeeNotFoundException;
import com.interview.employee.service.entity.Employee;
import com.interview.employee.service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findById(int id) throws EmployeeNotFoundException{
        Employee employee;
        employee = employeeRepository.findById(id).orElseThrow(() ->
        new EmployeeNotFoundException("No Employee found with id:  " + id));
        return employee;
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(int id, Employee employee) {
        Employee empDB = employeeRepository.findById(id).get();

        if (!ObjectUtils.isEmpty(employee.getFirstName()))
            empDB.setFirstName(employee.getFirstName());

        if (!ObjectUtils.isEmpty(employee.getLastName()))
            empDB.setLastName(employee.getLastName());

        if (!ObjectUtils.isEmpty(employee.getDept()))
            empDB.setDept(employee.getDept());

        return employeeRepository.save(empDB);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}

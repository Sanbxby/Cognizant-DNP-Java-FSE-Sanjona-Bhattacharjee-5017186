package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.entity.Department;
import com.example.employeemanagementsystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Get all departments
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Create a new department
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    // Get a department by ID
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department not found with id " + id));
    }

    // Update a department
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department updatedDepartment) {
        Department department = departmentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Department not found with id " + id));

        department.setName(updatedDepartment.getName());

        return departmentRepository.save(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        Department department = departmentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Department not found with id " + id));

        departmentRepository.delete(department);
    }
}

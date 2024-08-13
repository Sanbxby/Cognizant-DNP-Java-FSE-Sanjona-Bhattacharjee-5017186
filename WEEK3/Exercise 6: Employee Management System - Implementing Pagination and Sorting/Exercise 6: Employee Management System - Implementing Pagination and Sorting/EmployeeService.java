package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.entity.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeService {
    Page<Employee> getEmployeesWithPagination(int page, int size);
    Page<Employee> getEmployeesWithPaginationAndSorting(int page, int size, String sortBy, String sortDirection);
}

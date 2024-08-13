package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentName(String departmentName);
    Employee findByEmail(String email);
    List<Employee> findByNameContaining(String namePart);

    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName AND e.name LIKE %:name%")
    List<Employee> findByDepartmentNameAndEmployeeNameContaining(@Param("departmentName") String departmentName, @Param("name") String name);

    @Query(name = "Employee.findByDepartmentName")
    List<Employee> findByDepartmentNameNamedQuery(@Param("departmentName") String departmentName);
  
    @Query(name = "Employee.findByEmail")
    Employee findByEmailNamedQuery(@Param("email") String email);
}

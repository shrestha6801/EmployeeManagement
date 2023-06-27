package net.cts.backendemployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.cts.backendemployeeManagement.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByDepartmentId(int departmentId);
    List<Employee> findByGender(String gender);
    List<Employee> findByFirstNameContainingIgnoreCase(String firstName);
    // Add more custom query methods as per your requirements
}
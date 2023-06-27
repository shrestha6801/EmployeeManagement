package net.cts.backendemployeeManagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.cts.backendemployeeManagement.model.Salary;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer> {
    List<Salary> findByEmployeeId(int employeeId);
    // Add more custom query methods as per your requirements
}
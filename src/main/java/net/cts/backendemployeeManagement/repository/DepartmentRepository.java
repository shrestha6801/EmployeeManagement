package net.cts.backendemployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.cts.backendemployeeManagement.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    // Additional methods or custom queries can be defined here if needed
}
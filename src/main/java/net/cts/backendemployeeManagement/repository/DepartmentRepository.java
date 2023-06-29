package net.cts.backendemployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.cts.backendemployeeManagement.dto.DepartmentDTO;
import net.cts.backendemployeeManagement.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    // Add custom query methods if needed
}

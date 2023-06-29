package net.cts.backendemployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.cts.backendemployeeManagement.dto.EmployeeDTO;
import net.cts.backendemployeeManagement.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Add custom query methods if needed
}

package net.cts.backendemployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.cts.backendemployeeManagement.dto.SalaryDTO;
import net.cts.backendemployeeManagement.model.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer> {
    // Add custom query methods if needed
}

package net.cts.backendemployeeManagement.service;

import java.util.List;
import net.cts.backendemployeeManagement.dto.EmployeeDTO;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(int id);
    EmployeeDTO addEmployee(EmployeeDTO employee);
    EmployeeDTO updateEmployee(int id, EmployeeDTO employee);
    void deleteEmployee(int id);
}

package net.cts.backendemployeeManagement.service;

import java.util.List;
import net.cts.backendemployeeManagement.dto.DepartmentDTO;

public interface DepartmentService {
    List<DepartmentDTO> getAllDepartments();
    DepartmentDTO getDepartmentById(int id);
    DepartmentDTO addDepartment(DepartmentDTO department);
    DepartmentDTO updateDepartment(int id, DepartmentDTO department);
    void deleteDepartment(int id);
}

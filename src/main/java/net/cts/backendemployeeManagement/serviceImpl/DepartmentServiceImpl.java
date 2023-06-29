package net.cts.backendemployeeManagement.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cts.backendemployeeManagement.dto.DepartmentDTO;
import net.cts.backendemployeeManagement.model.Department;
import net.cts.backendemployeeManagement.repository.DepartmentRepository;
import net.cts.backendemployeeManagement.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO getDepartmentById(int id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with ID: " + id));
        return convertToDto(department);
    }

    @Override
    public DepartmentDTO addDepartment(DepartmentDTO departmentDto) {
        Department department = convertToEntity(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return convertToDto(savedDepartment);
    }

    @Override
    public DepartmentDTO updateDepartment(int id, DepartmentDTO departmentDto) {
        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with ID: " + id));
        Department updatedDepartment = updateEntity(existingDepartment, departmentDto);
        Department savedDepartment = departmentRepository.save(updatedDepartment);
        return convertToDto(savedDepartment);
    }

    @Override
    public void deleteDepartment(int id) {
        if (!departmentRepository.existsById(id)) {
            throw new RuntimeException("Department not found with ID: " + id);
        }
        departmentRepository.deleteById(id);
    }

    private DepartmentDTO convertToDto(Department department) {
        DepartmentDTO departmentDto = new DepartmentDTO();
        departmentDto.setDepartmentId(department.getDepartmentId());
        // Set other properties as needed
        return departmentDto;
    }

    private Department convertToEntity(DepartmentDTO departmentDto) {
        Department department = new Department();
        department.setDepartmentId(departmentDto.getDepartmentId());
        // Set other properties as needed
        return department;
    }

    private Department updateEntity(Department existingDepartment, DepartmentDTO departmentDto) {
        existingDepartment.setDepartmentId(departmentDto.getDepartmentId());
        // Update other properties as needed
        return existingDepartment;
    }
}

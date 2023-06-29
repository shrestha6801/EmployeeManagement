package net.cts.backendemployeeManagement.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cts.backendemployeeManagement.dto.EmployeeDTO;
import net.cts.backendemployeeManagement.model.Employee;
import net.cts.backendemployeeManagement.repository.EmployeeRepository;
import net.cts.backendemployeeManagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
        return convertToDto(employee);
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDto) {
        Employee employee = convertToEntity(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return convertToDto(savedEmployee);
    }

    @Override
    public EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDto) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
        Employee updatedEmployee = updateEntity(existingEmployee, employeeDto);
        Employee savedEmployee = employeeRepository.save(updatedEmployee);
        return convertToDto(savedEmployee);
    }

    @Override
    public void deleteEmployee(int id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found with ID: " + id);
        }
        employeeRepository.deleteById(id);
    }

    private EmployeeDTO convertToDto(Employee employee) {
        EmployeeDTO employeeDto = new EmployeeDTO();
        employeeDto.setId(employee.getId());
        // Set other properties as needed
        return employeeDto;
    }

    private Employee convertToEntity(EmployeeDTO employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        // Set other properties as needed
        return employee;
    }

    private Employee updateEntity(Employee existingEmployee, EmployeeDTO employeeDto) {
        existingEmployee.setId(employeeDto.getId());
        // Update other properties as needed
        return existingEmployee;
    }
}

package net.cts.backendemployeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cts.backendemployeeManagement.model.Salary;
import net.cts.backendemployeeManagement.repository.SalaryRepository;

import java.util.List;

@Service
public class SalaryService {
    private final SalaryRepository salaryRepository;

    @Autowired
    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    public List<Salary> getAllSalaries() {
        return salaryRepository.findAll();
    }

    public Salary getSalaryById(int salId) {
        return salaryRepository.findById(salId).orElse(null);
    }

    public Salary saveSalary(Salary salary) {
        return salaryRepository.save(salary);
    }

    public void deleteSalary(int salId) {
        salaryRepository.deleteById(salId);
    }

    public List<Salary> getSalariesByEmployee(int employeeId) {
        return salaryRepository.findByEmployeeId(employeeId);
    }

    // Additional methods or business logic specific to salaries can be defined here
}
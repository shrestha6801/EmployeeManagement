package net.cts.backendemployeeManagement.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cts.backendemployeeManagement.dto.SalaryDTO;
import net.cts.backendemployeeManagement.model.Salary;
import net.cts.backendemployeeManagement.repository.SalaryRepository;
import net.cts.backendemployeeManagement.service.SalaryService;

@Service
public class SalaryServiceImpl implements SalaryService {
	
	private final SalaryRepository salaryRepository;

	@Autowired
	public SalaryServiceImpl(SalaryRepository salaryRepository) {
	    this.salaryRepository = salaryRepository;
	}

	@Override
	public List<SalaryDTO> getAllSalaries() {
	    List<Salary> salaries = salaryRepository.findAll();
	    return salaries.stream()
	            .map(this::convertToDto)
	            .collect(Collectors.toList());
	}

	@Override
	public SalaryDTO getSalaryById(int id) {
	    Salary salary = salaryRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Salary not found with ID: " + id));
	    return convertToDto(salary);
	}

	@Override
	public SalaryDTO addSalary(SalaryDTO salaryDto) {
	    Salary salary = convertToEntity(salaryDto);
	    Salary savedSalary = salaryRepository.save(salary);
	    return convertToDto(savedSalary);
	}

	@Override
	public SalaryDTO updateSalary(int id, SalaryDTO salaryDto) {
	    Salary existingSalary = salaryRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Salary not found with ID: " + id));
	    Salary updatedSalary = updateEntity(existingSalary, salaryDto);
	    Salary savedSalary = salaryRepository.save(updatedSalary);
	    return convertToDto(savedSalary);
	}

	@Override
	public void deleteSalary(int id) {
	    if (!salaryRepository.existsById(id)) {
	        throw new RuntimeException("Salary not found with ID: " + id);
	    }
	    salaryRepository.deleteById(id);
	}

	private SalaryDTO convertToDto(Salary salary) {
	    SalaryDTO salaryDto = new SalaryDTO();
	    salaryDto.setSalId(salary.getSalId());
	    // Set other properties as needed
	    return salaryDto;
	}

	private Salary convertToEntity(SalaryDTO salaryDto) {
	    Salary salary = new Salary();
	    salary.setSalId(salaryDto.getSalId());
	    // Set other properties as needed
	    return salary;
	}

	private Salary updateEntity(Salary existingSalary, SalaryDTO salaryDto) {
	    existingSalary.setSalId(salaryDto.getSalId());
	    // Update other properties as needed
	    return existingSalary;
	}
}
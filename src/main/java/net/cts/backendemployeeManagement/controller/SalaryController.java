package net.cts.backendemployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import net.cts.backendemployeeManagement.dto.SalaryDTO;
import net.cts.backendemployeeManagement.model.Salary;
import net.cts.backendemployeeManagement.service.SalaryService;

import java.util.List;

@RestController
@RequestMapping("/salaries")
public class SalaryController {

    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping
    public ResponseEntity<List<SalaryDTO>> getAllSalaries() {
        List<SalaryDTO> salaries = salaryService.getAllSalaries();
        return new ResponseEntity<>(salaries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaryDTO> getSalaryById(@PathVariable("id") int id) {
        SalaryDTO salary = salaryService.getSalaryById(id);
        return new ResponseEntity<>(salary, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SalaryDTO> addSalary(@RequestBody SalaryDTO salary) {
        SalaryDTO addedSalary = salaryService.addSalary(salary);
        return new ResponseEntity<>(addedSalary, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaryDTO> updateSalary(
            @PathVariable("id") int id,
            @RequestBody SalaryDTO salary) {
        SalaryDTO updatedSalary = salaryService.updateSalary(id, salary);
        return new ResponseEntity<>(updatedSalary, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalary(@PathVariable("id") int id) {
        salaryService.deleteSalary(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

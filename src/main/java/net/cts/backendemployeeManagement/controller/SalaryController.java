package net.cts.backendemployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Salary>> getAllSalaries() {
        List<Salary> salaries = salaryService.getAllSalaries();
        return new ResponseEntity<>(salaries, HttpStatus.OK);
    }

    @GetMapping("/{salId}")
    public ResponseEntity<Salary> getSalaryById(@PathVariable int salId) {
        Salary salary = salaryService.getSalaryById(salId);
        if (salary != null) {
            return new ResponseEntity<>(salary, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Salary> saveSalary(@RequestBody Salary salary) {
        Salary savedSalary = salaryService.saveSalary(salary);
        return new ResponseEntity<>(savedSalary, HttpStatus.CREATED);
    }

    @PutMapping("/{salId}")
    public ResponseEntity<Salary> updateSalary(@PathVariable int salId, @RequestBody Salary salary) {
        Salary existingSalary = salaryService.getSalaryById(salId);
        if (existingSalary != null) {
            salary.setSalId(salId);
            Salary updatedSalary = salaryService.saveSalary(salary);
            return new ResponseEntity<>(updatedSalary, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{salId}")
    public ResponseEntity<Void> deleteSalary(@PathVariable int salId) {
        Salary existingSalary = salaryService.getSalaryById(salId);
        if (existingSalary != null) {
            salaryService.deleteSalary(salId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Additional endpoints or request mappings specific to salaries can be defined here

    // Exception handling
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
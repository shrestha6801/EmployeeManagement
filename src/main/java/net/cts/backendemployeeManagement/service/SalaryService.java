package net.cts.backendemployeeManagement.service;
import java.util.List;
import net.cts.backendemployeeManagement.dto.SalaryDTO;

public interface SalaryService {
    List<SalaryDTO> getAllSalaries();
    SalaryDTO getSalaryById(int id);
    SalaryDTO addSalary(SalaryDTO salary);
    SalaryDTO updateSalary(int id, SalaryDTO salary);
    void deleteSalary(int id);
}

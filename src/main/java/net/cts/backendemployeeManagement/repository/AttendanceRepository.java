package net.cts.backendemployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.cts.backendemployeeManagement.model.Attendance;

import java.util.Date;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    List<Attendance> findByEmployeeId(int employeeId);
    List<Attendance> findByDateBetween(Date startDate, Date endDate);
    // Add more custom query methods as per your requirements
}
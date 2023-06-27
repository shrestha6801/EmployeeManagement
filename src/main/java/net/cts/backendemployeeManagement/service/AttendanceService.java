package net.cts.backendemployeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cts.backendemployeeManagement.model.Attendance;
import net.cts.backendemployeeManagement.repository.AttendanceRepository;

import java.util.Date;
import java.util.List;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;

    @Autowired
    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    public Attendance getAttendanceById(int attendanceId) {
        return attendanceRepository.findById(attendanceId).orElse(null);
    }

    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public void deleteAttendance(int attendanceId) {
        attendanceRepository.deleteById(attendanceId);
    }

    public List<Attendance> getAttendancesByEmployee(int employeeId) {
        return attendanceRepository.findByEmployeeId(employeeId);
    }

    public List<Attendance> getAttendancesBetweenDates(Date startDate, Date endDate) {
        return attendanceRepository.findByDateBetween(startDate, endDate);
    }

    // Additional methods or business logic specific to attendance can be defined here
}
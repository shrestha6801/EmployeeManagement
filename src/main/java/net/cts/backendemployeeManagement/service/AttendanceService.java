package net.cts.backendemployeeManagement.service;

import java.util.List;
import net.cts.backendemployeeManagement.dto.AttendanceDTO;

public interface AttendanceService {
    List<AttendanceDTO> getAllAttendances();
    AttendanceDTO getAttendanceById(int id);
    AttendanceDTO addAttendance(AttendanceDTO attendance);
    AttendanceDTO updateAttendance(int id, AttendanceDTO attendance);
    void deleteAttendance(int id);
}

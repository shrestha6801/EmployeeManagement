package net.cts.backendemployeeManagement.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cts.backendemployeeManagement.dto.AttendanceDTO;
import net.cts.backendemployeeManagement.model.Attendance;
import net.cts.backendemployeeManagement.repository.AttendanceRepository;
import net.cts.backendemployeeManagement.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;

    @Autowired
    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public List<AttendanceDTO> getAllAttendances() {
        List<Attendance> attendances = attendanceRepository.findAll();
        return attendances.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AttendanceDTO getAttendanceById(int id) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found with ID: " + id));
        return convertToDto(attendance);
    }

    @Override
    public AttendanceDTO addAttendance(AttendanceDTO attendanceDto) {
        Attendance attendance = convertToEntity(attendanceDto);
        Attendance savedAttendance = attendanceRepository.save(attendance);
        return convertToDto(savedAttendance);
    }

    @Override
    public AttendanceDTO updateAttendance(int id, AttendanceDTO attendanceDto) {
        Attendance existingAttendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found with ID: " + id));
        Attendance updatedAttendance = updateEntity(existingAttendance, attendanceDto);
        Attendance savedAttendance = attendanceRepository.save(updatedAttendance);
        return convertToDto(savedAttendance);
    }

    @Override
    public void deleteAttendance(int id) {
        if (!attendanceRepository.existsById(id)) {
            throw new RuntimeException("Attendance not found with ID: " + id);
        }
        attendanceRepository.deleteById(id);
    }

    private AttendanceDTO convertToDto(Attendance attendance) {
        AttendanceDTO attendanceDto = new AttendanceDTO();
        attendanceDto.setAttendanceId(attendance.getAttendanceId());
        // Set other properties as needed
        return attendanceDto;
    }

    private Attendance convertToEntity(AttendanceDTO attendanceDto) {
        Attendance attendance = new Attendance();
        attendance.setAttendanceId(attendanceDto.getAttendanceId());
        // Set other properties as needed
        return attendance;
    }

    private Attendance updateEntity(Attendance existingAttendance, AttendanceDTO attendanceDto) {
        existingAttendance.setAttendanceId(attendanceDto.getAttendanceId());
        // Update other properties as needed
        return existingAttendance;
    }
}

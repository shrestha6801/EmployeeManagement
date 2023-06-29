package net.cts.backendemployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import net.cts.backendemployeeManagement.dto.AttendanceDTO;
import net.cts.backendemployeeManagement.model.Attendance;
import net.cts.backendemployeeManagement.service.AttendanceService;

import java.util.List;

@RestController
@RequestMapping("/attendances")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping
    public ResponseEntity<List<AttendanceDTO>> getAllAttendances() {
        List<AttendanceDTO> attendances = attendanceService.getAllAttendances();
        return new ResponseEntity<>(attendances, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttendanceDTO> getAttendanceById(@PathVariable("id") int id) {
        AttendanceDTO attendance = attendanceService.getAttendanceById(id);
        return new ResponseEntity<>(attendance, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AttendanceDTO> addAttendance(@RequestBody AttendanceDTO attendance) {
        AttendanceDTO addedAttendance = attendanceService.addAttendance(attendance);
        return new ResponseEntity<>(addedAttendance, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttendanceDTO> updateAttendance(
            @PathVariable("id") int id,
            @RequestBody AttendanceDTO attendance) {
        AttendanceDTO updatedAttendance = attendanceService.updateAttendance(id, attendance);
        return new ResponseEntity<>(updatedAttendance, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable("id") int id) {
        attendanceService.deleteAttendance(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

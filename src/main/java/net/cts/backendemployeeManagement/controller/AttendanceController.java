package net.cts.backendemployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.cts.backendemployeeManagement.model.Attendance;
import net.cts.backendemployeeManagement.service.AttendanceService;

import java.util.Date;
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
    public ResponseEntity<List<Attendance>> getAllAttendances() {
        List<Attendance> attendances = attendanceService.getAllAttendances();
        return new ResponseEntity<>(attendances, HttpStatus.OK);
    }

    @GetMapping("/{attendanceId}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable int attendanceId) {
        Attendance attendance = attendanceService.getAttendanceById(attendanceId);
        if (attendance != null) {
            return new ResponseEntity<>(attendance, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Attendance> saveAttendance(@RequestBody Attendance attendance) {
        Attendance savedAttendance = attendanceService.saveAttendance(attendance);
        return new ResponseEntity<>(savedAttendance, HttpStatus.CREATED);
    }

    @PutMapping("/{attendanceId}")
    public ResponseEntity<Attendance> updateAttendance(@PathVariable int attendanceId, @RequestBody Attendance attendance) {
        Attendance existingAttendance = attendanceService.getAttendanceById(attendanceId);
        if (existingAttendance != null) {
            attendance.setAttendanceId(attendanceId);
            Attendance updatedAttendance = attendanceService.saveAttendance(attendance);
            return new ResponseEntity<>(updatedAttendance, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{attendanceId}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable int attendanceId) {
        Attendance existingAttendance = attendanceService.getAttendanceById(attendanceId);
        if (existingAttendance != null) {
            attendanceService.deleteAttendance(attendanceId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Additional endpoints or request mappings specific to attendance can be defined here

    // Exception handling
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

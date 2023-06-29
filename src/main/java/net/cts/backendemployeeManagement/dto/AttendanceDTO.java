package net.cts.backendemployeeManagement.dto;

import java.sql.Date;

public class AttendanceDTO {
    private int attendanceId;
    private int id;
    private Date date;
    
    public int getAttendanceId() {
        return attendanceId;
    }
    
    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    // Constructors, getters, and setters
    // ...
}

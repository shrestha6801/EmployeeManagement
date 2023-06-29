package net.cts.backendemployeeManagement.dto;


public class EmployeeDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private DepartmentDTO department;
    private SalaryDTO salary;
    private AttendanceDTO attendance;

    // Constructors, getters, and setters
    // ...

    public EmployeeDTO() {
    }

    public EmployeeDTO(int id, String firstName, String lastName, String email, String gender, DepartmentDTO department, SalaryDTO salary, AttendanceDTO attendance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.attendance = attendance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

    public SalaryDTO getSalary() {
        return salary;
    }

    public void setSalary(SalaryDTO salary) {
        this.salary = salary;
    }

    public AttendanceDTO getAttendance() {
        return attendance;
    }

    public void setAttendance(AttendanceDTO attendance) {
        this.attendance = attendance;
    }

    // Getters and setters for individual fields

    // ...
}
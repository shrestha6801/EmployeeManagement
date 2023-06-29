
package net.cts.backendemployeeManagement.dto;

public class SalaryDTO {
    private int salId;
    private int id;
    private double amount;
    private String payroll;
    
    public int getSalId() {
        return salId;
    }
    
    public void setSalId(int salId) {
        this.salId = salId;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public String getPayroll() {
        return payroll;
    }
    
    public void setPayroll(String payroll) {
        this.payroll = payroll;
    }
    
    // Constructors, getters, and setters
    // ...
}

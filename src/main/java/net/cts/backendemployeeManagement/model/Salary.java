package net.cts.backendemployeeManagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sal_id")
    private int salId;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    private double amount;

    private String payroll;

	public int getSalId() {
		return salId;
	}

	public void setSalId(int salId) {
		this.salId = salId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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

	public Salary(int salId, Employee employee, double amount, String payroll) {
		super();
		this.salId = salId;
		this.employee = employee;
		this.amount = amount;
		this.payroll = payroll;
	}

	@Override
	public String toString() {
		return "Salary [salId=" + salId + ", employee=" + employee + ", amount=" + amount + ", payroll=" + payroll
				+ "]";
	}

    // Constructors, getters, and setters

    // ...
    
}
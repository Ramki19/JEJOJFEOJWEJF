package com.example.Approvel.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class LeaveRequest {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fromdate;
    private LocalDate todate;
private String reason;

    public LeaveRequest() {

    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LeaveRequest(Long id, LocalDate fromdate, LocalDate todate, String reason, Status status, Employee employee) {
        this.id = id;
        this.fromdate = fromdate;
        this.todate = todate;
        this.reason = reason;
        this.status = status;
    }

    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private Employee employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFromdate() {
        return fromdate;
    }

    public void setFromdate(LocalDate fromdate) {
        this.fromdate = fromdate;
    }

    public LocalDate getTodate() {
        return todate;
    }

    public void setTodate(LocalDate todate) {
        this.todate = todate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }



}

package com.example.Approvel.Dto;

import com.example.Approvel.Model.Role;
import com.example.Approvel.Model.Status;

import java.time.LocalDate;
import java.util.Stack;

public class Responsedto {
    private Long id;
    private Long empid;
    private String empname;
    private Role role;
    private LocalDate fromdate;
    private LocalDate todate;
    private String reason;
    private Status Status;

    public Responsedto(Long id, Long empid, String empname, Role role, LocalDate fromdate, LocalDate todate, String reason, Status status) {
        this.id = id;
        this.empid = empid;
        this.empname = empname;
        this.role = role;
        this.fromdate = fromdate;
        this.todate = todate;
        this.reason = reason;
        Status = status;
    }

    public Status getStatus() {
        return Status;
    }

    public void setStatus(Status status) {
        Status = status;
    }

    public Responsedto(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmpid() {
        return empid;
    }

    public void setEmpid(Long empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

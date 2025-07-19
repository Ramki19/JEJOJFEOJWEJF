package com.example.Approvel.Dto;

import com.example.Approvel.Model.Status;

import java.time.LocalDate;

public class Dto {
    private Long id;
    private String reason;
    private LocalDate fromdate;
    private LocalDate todate;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private Status status;

    public Dto(Long id, String reason, LocalDate fromdate, LocalDate todate, Status status) {
        this.id = id;
        this.reason = reason;
        this.fromdate = fromdate;
        this.todate = todate;
        this.status = status;
    }

    public Dto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public Dto(Long id, String reason, LocalDate fromdate, LocalDate todate) {
        this.id = id;
        this.reason = reason;
        this.fromdate = fromdate;
        this.todate = todate;
    }
    public Dto(){

    }
}

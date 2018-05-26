package com.chuan.servlet.flight.bean;

import java.time.LocalDateTime;

public class ScheduleBean {
    // main data
    private int scheduleId;
    private int flightId;
    private int status; // status 0 pending / 1 publish / 2 freeze
    private LocalDateTime departureTime;
    // query/calculate data, can be ignored
    private LocalDateTime arrivalTime;
    private int availableSeatsFirst;
    private int availableSeatsBusiness;
    private int availableSeatsEconomy;

    public ScheduleBean(int scheduleId, int flightId, int status, LocalDateTime departureTime) {
        this.scheduleId = scheduleId;
        this.flightId = flightId;
        this.status = status;
        this.departureTime = departureTime;
    }

    public ScheduleBean(int scheduleId, int flightId, LocalDateTime departureTime, LocalDateTime arrivalTime, int availableSeatsFirst, int availableSeatsBusiness, int availableSeatsEconomy) {
        this.scheduleId = scheduleId;
        this.flightId = flightId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.availableSeatsFirst = availableSeatsFirst;
        this.availableSeatsBusiness = availableSeatsBusiness;
        this.availableSeatsEconomy = availableSeatsEconomy;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getAvailableSeatsFirst() {
        return availableSeatsFirst;
    }

    public void setAvailableSeatsFirst(int availableSeatsFirst) {
        this.availableSeatsFirst = availableSeatsFirst;
    }

    public int getAvailableSeatsBusiness() {
        return availableSeatsBusiness;
    }

    public void setAvailableSeatsBusiness(int availableSeatsBusiness) {
        this.availableSeatsBusiness = availableSeatsBusiness;
    }

    public int getAvailableSeatsEconomy() {
        return availableSeatsEconomy;
    }

    public void setAvailableSeatsEconomy(int availableSeatsEconomy) {
        this.availableSeatsEconomy = availableSeatsEconomy;
    }
}
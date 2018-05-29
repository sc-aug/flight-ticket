package com.chuan.servlet.flight.bean;

import java.time.LocalDateTime;

public class ScheduleBean {
    // main data
    private int scheduleId;
    private int flightId;
    private int statusId; // status 1 pending / 2 publish / 3 freeze
    private String statusName;
    private String airplaneName;
    private String depLocName;
    private String arrLocName;
    private LocalDateTime departureTime;
    // query/calculate data, can be ignored
    private LocalDateTime arrivalTime;
    private int availableSeatsFirst;
    private int availableSeatsBusiness;
    private int availableSeatsEconomy;

    public ScheduleBean(int scheduleId, int flightId, int statusId, LocalDateTime departureTime) {
        this.scheduleId = scheduleId;
        this.flightId = flightId;
        this.statusId = statusId;
        this.departureTime = departureTime;
    }

    public ScheduleBean(int scheduleId, int flightId, int statusId, String statusName,
                        String airplaneName, String depLocName, String arrLocName,
                        LocalDateTime departureTime, LocalDateTime arrivalTime,
                        int availableSeatsFirst, int availableSeatsBusiness, int availableSeatsEconomy) {
        this.scheduleId = scheduleId;
        this.flightId = flightId;
        this.statusId = statusId;
        this.statusName = statusName;
        this.airplaneName = airplaneName;
        this.depLocName = depLocName;
        this.arrLocName = arrLocName;
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

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    public String getDepLocName() {
        return depLocName;
    }

    public void setDepLocName(String depLocName) {
        this.depLocName = depLocName;
    }

    public String getArrLocName() {
        return arrLocName;
    }

    public void setArrLocName(String arrLocName) {
        this.arrLocName = arrLocName;
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
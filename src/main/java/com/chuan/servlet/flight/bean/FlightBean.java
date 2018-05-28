package com.chuan.servlet.flight.bean;

import java.time.LocalDateTime;

public class FlightBean {
    private int flightId;
    private int airplaneId;
    private String airplaneName;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int departureLocId;
    private int arrivalLocId;
    private String departureLoc;
    private String arrivalLoc;

    public FlightBean(int flightId, int airplaneId, String airplaneName, LocalDateTime departureTime, LocalDateTime arrivalTime,
                      int departureLocId, int arrivalLocId, String departureLoc, String arrivalLoc) {
        this.flightId = flightId;
        this.airplaneId = airplaneId;
        this.airplaneName = airplaneName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureLocId = departureLocId;
        this.arrivalLocId = arrivalLocId;
        this.departureLoc = departureLoc;
        this.arrivalLoc = arrivalLoc;
    }

    @Override
    public String toString() {
        return "FlightBean{" +
                "flightId=" + flightId +
                ", airplaneId=" + airplaneId +
                ", airplaneName='" + airplaneName + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", departureLocId=" + departureLocId +
                ", arrivalLocId=" + arrivalLocId +
                ", departureLoc='" + departureLoc + '\'' +
                ", arrivalLoc='" + arrivalLoc + '\'' +
                '}';
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
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

    public int getDepartureLocId() {
        return departureLocId;
    }

    public void setDepartureLocId(int departureLocId) {
        this.departureLocId = departureLocId;
    }

    public int getArrivalLocId() {
        return arrivalLocId;
    }

    public void setArrivalLocId(int arrivalLocId) {
        this.arrivalLocId = arrivalLocId;
    }

    public String getDepartureLoc() {
        return departureLoc;
    }

    public void setDepartureLoc(String departureLoc) {
        this.departureLoc = departureLoc;
    }

    public String getArrivalLoc() {
        return arrivalLoc;
    }

    public void setArrivalLoc(String arrivalLoc) {
        this.arrivalLoc = arrivalLoc;
    }
}

package com.chuan.servlet.flight.bean;

import java.time.LocalDateTime;

public class FlightBean {
    private int flightId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int departureLocId;
    private int arrivalLocId;
    private int airplaneId;
    private String departureLoc;
    private String arrivalLoc;
    private String airplaneName;

    public FlightBean(int flightId, LocalDateTime dTime, LocalDateTime aTime, int dLocId, int aLocId,
                      int airplaneId, String dLoc, String aLoc, String airplaneName) {
        this.flightId = flightId;
        this.departureTime = dTime;
        this.arrivalTime = aTime;
        this.departureLocId = dLocId;
        this.arrivalLocId = aLocId;
        this.airplaneId = airplaneId;
        this.departureLoc = dLoc;
        this.arrivalLoc = aLoc;
        this.airplaneName = airplaneName;
    }

    @Override
    public String toString() {
        return "FlightBean{" +
                "flightId=" + flightId +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", departureLocId=" + departureLocId +
                ", arrivalLocId=" + arrivalLocId +
                ", airplaneId=" + airplaneId +
                ", departureLoc='" + departureLoc + '\'' +
                ", arrivalLoc='" + arrivalLoc + '\'' +
                ", airplaneName='" + airplaneName + '\'' +
                '}';
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
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

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
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

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }
}

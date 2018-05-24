package com.chuan.servlet.flight.bean;

import java.time.LocalDateTime;

public class FlightBean {
    private int flightId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String departureCity;
    private String arrivalCity;
    private String airplaneName;


    public FlightBean(int flightId, LocalDateTime departureTime, LocalDateTime arrivalTime, String departureCity, String arrivalCity, String airplaneName) {
        this.flightId = flightId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.airplaneName = airplaneName;
    }

    @Override
    public String toString() {
        return "FlightBean{" +
                "flightId=" + flightId +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", departureCity='" + departureCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
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

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void getAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }
}

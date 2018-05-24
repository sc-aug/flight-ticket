package com.chuan.servlet.flight.bean;

import java.time.LocalDateTime;

public class FlightBean {
    private int flightId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int departureCityId;
    private int arrivalCityId;
    private int airplaneId;
    private String departureCity;
    private String arrivalCity;
    private String airplaneName;

    public FlightBean(int flightId, LocalDateTime departureTime, LocalDateTime arrivalTime,
                      int departureCityId, int arrivalCityId, int airplaneId,
                      String departureCity, String arrivalCity, String airplaneName) {
        this.flightId = flightId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureCityId = departureCityId;
        this.arrivalCityId = arrivalCityId;
        this.airplaneId = airplaneId;
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
                ", departureCityId=" + departureCityId +
                ", arrivalCityId=" + arrivalCityId +
                ", airplaneId=" + airplaneId +
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

    public int getDepartureCityId() {
        return departureCityId;
    }

    public void setDepartureCityId(int departureCityId) {
        this.departureCityId = departureCityId;
    }

    public int getArrivalCityId() {
        return arrivalCityId;
    }

    public void setArrivalCityId(int arrivalCityId) {
        this.arrivalCityId = arrivalCityId;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
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

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }
}

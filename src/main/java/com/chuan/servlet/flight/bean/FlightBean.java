package com.chuan.servlet.flight.bean;

public class FlightBean {
    private int flightId;
    private String departureTime;
    private String arrivalTime;
    private String departureCity;
    private String arrivalCity;
    private String airplaneName;


    public FlightBean(int flightId, String departureTime, String arrivalTime, String departureCity, String arrivalCity, String airplaneName) {
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

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
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

package com.chuan.servlet.flight.bean;

import java.util.Map;

public class AirplaneBean {
    private int airplaneId;
    private String airplaneName;
    private int seatFirst;
    private int seatBusiness;
    private int seatEconomy;

    public AirplaneBean(int airplaneId, String airplaneName) {
        this.airplaneId = airplaneId;
        this.airplaneName = airplaneName;
    }

    public AirplaneBean(int airplaneId, String airplaneName, int seatFirst, int seatBusiness, int seatEconomy) {
        this.airplaneId = airplaneId;
        this.airplaneName = airplaneName;
        this.seatFirst = seatFirst;
        this.seatBusiness = seatBusiness;
        this.seatEconomy = seatEconomy;
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

    public int getSeatFirst() {
        return seatFirst;
    }

    public void setSeatFirst(int seatFirst) {
        this.seatFirst = seatFirst;
    }

    public int getSeatBusiness() {
        return seatBusiness;
    }

    public void setSeatBusiness(int seatBusiness) {
        this.seatBusiness = seatBusiness;
    }

    public int getSeatEconomy() {
        return seatEconomy;
    }

    public void setSeatEconomy(int seatEconomy) {
        this.seatEconomy = seatEconomy;
    }
}

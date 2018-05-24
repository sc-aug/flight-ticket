package com.chuan.servlet.flight.bean;

public class AirplaneBean {
    private int airplaneId;
    private String airplaneName;

    public AirplaneBean(int airplaneId, String airplaneName) {
        this.airplaneId = airplaneId;
        this.airplaneName = airplaneName;
    }

    @Override
    public String toString() {
        return "AirplaneBean{" +
                "airplaneId=" + airplaneId +
                ", airplaneName='" + airplaneName + '\'' +
                '}';
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
}

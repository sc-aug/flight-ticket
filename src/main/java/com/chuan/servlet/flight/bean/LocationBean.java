package com.chuan.servlet.flight.bean;

import java.time.LocalDateTime;

public class LocationBean {
    private int locationId;
    private String locationName;
    private String timezone;

    public LocationBean(int locationId, String locationName, String timezone) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.timezone = timezone;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}

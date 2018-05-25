package com.chuan.servlet.flight.service;

import com.chuan.servlet.flight.bean.LocationBean;

import java.util.List;

public interface LocationService {
    // get all locations
    public List<LocationBean> getAllLocations();
    // get location by id
    public LocationBean getLocationById(int locId);
    // edit location
    public int updateLocation(LocationBean loc);
    // delete location by id
    public int deleteLocation(int locId);
}

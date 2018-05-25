package com.chuan.servlet.flight.service;

import com.chuan.servlet.flight.bean.LocationBean;
import com.chuan.servlet.flight.dao.LocationDAOImpl;

import java.util.List;

public class LocationServiceImpl implements LocationService {
    @Override
    public List<LocationBean> getAllLocations() {
        return new LocationDAOImpl().getAllLocations();
    }

    @Override
    public LocationBean getLocationById(int locId) {
        return new LocationDAOImpl().getLocationById(locId);
    }

    @Override
    public int updateLocation(LocationBean loc) {
        return new LocationDAOImpl().updateLocation(loc);
    }

    @Override
    public int deleteLocation(int locId) {
        return new LocationDAOImpl().deleteLocation(locId);
    }
}

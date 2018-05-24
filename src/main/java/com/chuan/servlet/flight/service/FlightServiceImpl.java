package com.chuan.servlet.flight.service;

import com.chuan.servlet.flight.bean.FlightBean;
import com.chuan.servlet.flight.dao.FlightDAOImpl;

import java.util.List;

public class FlightServiceImpl implements FlightService {
    @Override
    public boolean addFlight(FlightBean f) {
        return false;
    }

    @Override
    public boolean getFlightById(int fId) {
        return false;
    }

    @Override
    public List<FlightBean> getAllFlights() {
        return new FlightDAOImpl().getAllFlights();
    }
}

package com.chuan.servlet.flight.service;

import com.chuan.servlet.flight.bean.FlightBean;
import com.chuan.servlet.flight.dao.FlightDAOImpl;

import java.util.List;

public class FlightServiceImpl implements FlightService {
    @Override
    public int addFlight(FlightBean f) {
        return new FlightDAOImpl().addFlight(f);
    }

    @Override
    public int editFlight(FlightBean f) {
        return new FlightDAOImpl().editFlight(f);
    }

    @Override
    public FlightBean getFlightById(int fId) {
        return new FlightDAOImpl().getFlightById(fId);
    }

    @Override
    public List<FlightBean> getAllFlights() {
        return new FlightDAOImpl().getAllFlights();
    }
}

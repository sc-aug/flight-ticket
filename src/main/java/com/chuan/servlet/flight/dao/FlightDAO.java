package com.chuan.servlet.flight.dao;

import com.chuan.servlet.flight.bean.FlightBean;

import java.util.List;

public interface FlightDAO {
    // add flight
    public int addFlight(FlightBean f);
    // get flight
    public FlightBean getFlightById(int fId);
    // get all flights
    public List<FlightBean> getAllFlights();
}

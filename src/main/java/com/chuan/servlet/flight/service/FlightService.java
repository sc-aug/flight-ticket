package com.chuan.servlet.flight.service;

import com.chuan.servlet.flight.bean.FlightBean;

import java.util.List;

public interface FlightService {
    // add flight
    public int addFlight(FlightBean f);
    // edit flight
    public int editFlight(FlightBean f);
    // get flight
    public FlightBean getFlightById(int fId);
    // get all flights
    public List<FlightBean> getAllFlights();
}

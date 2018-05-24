package com.chuan.servlet.flight.dao;

import com.chuan.servlet.flight.bean.FlightBean;

import java.util.List;

public interface FlightDAO {
    // add flight
    public boolean addFlight(FlightBean f);
    // get flight
    public boolean getFlightById(int fId);
    // get all flights
    public List<FlightBean> getAllFlights();
}

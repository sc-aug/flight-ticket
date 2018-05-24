package com.chuan.servlet.flight.service;

import com.chuan.servlet.flight.bean.AirplaneBean;

import java.util.List;

public interface AirplaneService {
    // get all airplane
    public List<AirplaneBean> getAllAirplanes();
}

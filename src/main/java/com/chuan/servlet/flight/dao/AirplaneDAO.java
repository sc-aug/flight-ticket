package com.chuan.servlet.flight.dao;

import com.chuan.servlet.flight.bean.AirplaneBean;

import java.util.List;

public interface AirplaneDAO {
    // get all airplane
    public List<AirplaneBean> getAllAirplanes();
}

package com.chuan.servlet.flight.dao;

import com.chuan.servlet.flight.bean.AirplaneBean;

import java.util.List;

public interface AirplaneDAO {
    // get all airplane
    public List<AirplaneBean> getAllAirplanes();
    // get airplane by id
    public AirplaneBean getAirplaneById(int airplaneId);
    // update airplane
    public int updateAirplane(AirplaneBean airplane);
}

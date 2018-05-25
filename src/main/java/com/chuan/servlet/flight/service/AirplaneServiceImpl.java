package com.chuan.servlet.flight.service;

import com.chuan.servlet.flight.bean.AirplaneBean;
import com.chuan.servlet.flight.dao.AirplaneDAOImpl;

import java.util.List;

public class AirplaneServiceImpl implements AirplaneService {
    @Override
    public List<AirplaneBean> getAllAirplanes() {
        return new AirplaneDAOImpl().getAllAirplanes();
    }

    @Override
    public AirplaneBean getAirplaneById(int airplaneId) {
        return new AirplaneDAOImpl().getAirplaneById(airplaneId);
    }
}

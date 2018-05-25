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
    @Override
    public int updateAirplane(AirplaneBean airplane) {
        return new AirplaneDAOImpl().updateAirplane(airplane);
    }
    @Override
    public int addAirplane(AirplaneBean airplane) {
        return new AirplaneDAOImpl().addAirplane(airplane);
    }
    @Override
    public int deleteAirplaneById(int airplaneId) {
        return new AirplaneDAOImpl().deleteAirplaneById(airplaneId);
    }
}

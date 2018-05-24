package com.chuan.servlet.flight.service;

import com.chuan.servlet.flight.bean.SeatTypeBean;
import com.chuan.servlet.flight.dao.SeatTypeDAOImpl;

import java.util.List;

public class SeatTypeServiceImpl implements SeatTypeService{
    @Override
    public List<SeatTypeBean> getAllSeatTypes() {
        return new SeatTypeDAOImpl().getAllSeatTypes();
    }
}

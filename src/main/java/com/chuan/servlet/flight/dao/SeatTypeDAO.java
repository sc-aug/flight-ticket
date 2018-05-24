package com.chuan.servlet.flight.dao;

import com.chuan.servlet.flight.bean.SeatTypeBean;

import java.util.List;

public interface SeatTypeDAO {
    // get all seat type
    public List<SeatTypeBean> getAllSeatTypes();
}

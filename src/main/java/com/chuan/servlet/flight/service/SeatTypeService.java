package com.chuan.servlet.flight.service;

import com.chuan.servlet.flight.bean.SeatTypeBean;

import java.util.List;

public interface SeatTypeService {
    // get all seat type
    public List<SeatTypeBean> getAllSeatTypes();
}

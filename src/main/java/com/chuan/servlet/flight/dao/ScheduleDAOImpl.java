package com.chuan.servlet.flight.dao;

import com.chuan.servlet.flight.bean.ScheduleBean;

import java.util.List;

public class ScheduleDAOImpl implements ScheduleDAO {

    @Override
    public List<ScheduleBean> getAllSchedules() {
        return null;
    }

    @Override
    public ScheduleBean getScheduleById() {
        return null;
    }

    @Override
    public int addSchedule(ScheduleBean s) {
        return 0;
    }

    @Override
    public int updateSchedule(ScheduleBean s) {
        return 0;
    }

    @Override
    public int updateSchedule(int sId, int status) {
        // 0 -> 1
        // 1 -> 2
        // 2 -> 1
        return 0;
    }

    @Override
    public int deleteScheduleById(int sId) {
        // can not delete schedule with status of 1
        return 0;
    }
}

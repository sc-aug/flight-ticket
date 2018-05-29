package com.chuan.servlet.flight.service;

import com.chuan.servlet.flight.bean.ScheduleBean;
import com.chuan.servlet.flight.dao.ScheduleDAOImpl;

import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {

    @Override
    public List<ScheduleBean> getAllSchedules() {
        return new ScheduleDAOImpl().getAllSchedules();
    }

    @Override
    public ScheduleBean getScheduleById(int sId) {
        return new ScheduleDAOImpl().getScheduleById(sId);
    }

    @Override
    public int addSchedule(ScheduleBean s) {
        return new ScheduleDAOImpl().addSchedule(s);
    }

    @Override
    public int updateSchedule(ScheduleBean s) {
        return new ScheduleDAOImpl().updateSchedule(s);
    }

    @Override
    public int updateSchedule(int sId, int status) {
        return new ScheduleDAOImpl().updateSchedule(sId, status);
    }

    @Override
    public int deleteScheduleById(int sId) {
        return new ScheduleDAOImpl().deleteScheduleById(sId);
    }
}

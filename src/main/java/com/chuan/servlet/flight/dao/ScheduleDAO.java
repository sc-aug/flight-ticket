package com.chuan.servlet.flight.dao;

import com.chuan.servlet.flight.bean.ScheduleBean;

import java.util.List;

public interface ScheduleDAO {
    // get all schedules
    public List<ScheduleBean> getAllSchedules();
    // get schedule by id
    public ScheduleBean getScheduleById();
    // add schedule
    public int addSchedule(ScheduleBean s);
    // update schedule
    public int updateSchedule(ScheduleBean s);
    // update status
    public int updateSchedule(int sId, int status);
    // delete schedule
    public int deleteScheduleById(int sId);
}

package com.chuan.servlet.flight.dao;

import com.chuan.servlet.flight.bean.ScheduleBean;
import com.chuan.servlet.flight.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAOImpl implements ScheduleDAO {

    @Override
    public List<ScheduleBean> getAllSchedules() {
        List<ScheduleBean> sl = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM schedule ORDER BY schedule_id";
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                sl.add(new ScheduleBean(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getTimestamp(4).toLocalDateTime()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps, rs);
        }
        return sl;
    }

    @Override
    public ScheduleBean getScheduleById() {
        return null;
    }

    @Override
    public int addSchedule(ScheduleBean s) {
        Connection con = null;
        PreparedStatement ps = null;
        int res = -1;
        String query = "INSERT INTO schedule VALUES(DEFAULT, ?, ?, ?::TIMESTAMP)";
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String depT = s.getDepartureTime().format(formatter);
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            ps.setInt(1, s.getFlightId());
            ps.setInt(2, s.getStatus());
            ps.setString(3, depT);
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps);
        }
        return res;
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

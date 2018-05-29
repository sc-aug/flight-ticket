package com.chuan.servlet.flight.dao;

import com.chuan.servlet.flight.bean.ScheduleBean;
import com.chuan.servlet.flight.util.DBUtil;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
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
        String query = "SELECT * FROM view_schedule_info ORDER BY schedule_id";
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                int schId = rs.getInt(1);
                int fId = rs.getInt(2);
                int statusId = rs.getInt(3);
                String statusName = rs.getString(4);
                String airplaneName = rs.getString(5);
                String depLocName = rs.getString(6);
                String arrLocName = rs.getString(7);
                int first = rs.getInt(8);
                int business = rs.getInt(9);
                int economy = rs.getInt(10);
                LocalDateTime dt = rs.getTimestamp(11).toLocalDateTime();
                LocalDateTime rdt = rs.getTimestamp(12).toLocalDateTime();
                LocalDateTime rat = rs.getTimestamp(13).toLocalDateTime();
                LocalDateTime at = rat.plus(Duration.between(rdt, dt));

                sl.add(new ScheduleBean(
                        schId, fId, statusId, statusName,
                        airplaneName, depLocName, arrLocName,
                        dt, at, first, business, economy));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps, rs);
        }
        return sl;
    }

    @Override
    public ScheduleBean getScheduleById(int sId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ScheduleBean sb = null;
        String query = "SELECT * FROM schedule WHERE schedule_id = ? ORDER BY schedule_id";
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareCall(query);
            ps.setInt(1, sId);
            rs = ps.executeQuery();
            if (rs.next()) {
                sb = new ScheduleBean(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getTimestamp(4).toLocalDateTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps, rs);
        }
        return sb;
    }

    @Override
    public int addSchedule(ScheduleBean s) {
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        int res = -1;
        String query = "SELECT fn_insert_schedule(?, ?::TIMESTAMP)";
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String depT = s.getDepartureTime().format(formatter);
        try {
            con = DBUtil.getConnectionObject();
            cs = con.prepareCall(query);
            cs.setInt(1, s.getFlightId());
            cs.setString(2, depT);
            rs = cs.executeQuery();
            if (rs.next()) {
                res = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, cs, rs);
        }
        return res;
    }

    @Override
    public int updateSchedule(ScheduleBean s) {
        return 0;
    }

    @Override
    public int updateSchedule(int sId, int status) {
        // 1 -> 2
        // 2 -> 3
        // 3 -> 2
        return 0;
    }

    @Override
    public int deleteScheduleById(int sId) {
        // can not delete schedule with status of 1
        return 0;
    }
}

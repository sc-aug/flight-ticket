package com.chuan.servlet.flight.dao;

import com.chuan.servlet.flight.bean.FlightBean;
import com.chuan.servlet.flight.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FlightDAOImpl implements FlightDAO {

    @Override
    public int editFlight(FlightBean flight) {
        Connection con = null;
        PreparedStatement ps = null;
        int res = -1;
        String query = "UPDATE flight SET " +
                "relative_departure_time = ?::TIMESTAMP," +
                "relative_arrival_time = ?::TIMESTAMP," +
                "departure_loc_id = ?," +
                "arrival_loc_id = ?, " +
                "airplane_id = ? " +
                "WHERE flight_id = ?";
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String depT = flight.getDepartureTime().format(formatter);
        String arrT = flight.getArrivalTime().format(formatter);

        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            ps.setString(1, depT);
            ps.setString(2, arrT);
            ps.setInt(3, flight.getDepartureLocId());
            ps.setInt(4, flight.getArrivalLocId());
            ps.setInt(5, flight.getAirplaneId());
            ps.setInt(6, flight.getFlightId());
            // execute
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps);
        }
        return res;
    }

    @Override
    public int addFlight(FlightBean f) {
        Connection con = null;
        PreparedStatement ps = null;
        FlightBean flight = null;
        int res = -1;
        String query = "INSERT INTO flight VALUES (DEFAULT, " +
                "?::TIMESTAMP, " +
                "?::TIMESTAMP, ?, ?, ?)";
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String depT = f.getDepartureTime().format(formatter);
        String arrT = f.getArrivalTime().format(formatter);

        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            ps.setString(1, depT);
            ps.setString(2, arrT);
            ps.setInt(3, f.getDepartureLocId());
            ps.setInt(4, f.getArrivalLocId());
            ps.setInt(5, f.getAirplaneId());
            // execute
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps);
        }
        return res;
    }

    @Override
    public FlightBean getFlightById(int fId) {
        Connection con = null;
        PreparedStatement ps = null;
        FlightBean flight = null;
        ResultSet rs = null;
        String query = "SELECT * FROM view_flight_detail WHERE flight_id = ?";
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            ps.setInt(1, fId);
            rs = ps.executeQuery();
            if(rs.next()) {
                flight = new FlightBean(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getTimestamp(4).toLocalDateTime(),
                        rs.getTimestamp(5).toLocalDateTime(),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps, rs);
        }
        return flight;
    }

    @Override
    public List<FlightBean> getAllFlights() {
        Connection con = null;
        PreparedStatement ps = null;
        List<FlightBean> fl = new ArrayList<FlightBean>();
        ResultSet rs = null;
        String query = "SELECT * FROM view_flight_detail";
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                fl.add(new FlightBean(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getTimestamp(4).toLocalDateTime(),
                        rs.getTimestamp(5).toLocalDateTime(),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps, rs);
        }
        return fl;
    }

    @Override
    public int deleteFlightById(int fId) {
        Connection con = null;
        PreparedStatement ps = null;
        FlightBean flight = null;
        int res = -1;
        String query = "DELETE FROM flight WHERE flight_id = ?";
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            ps.setInt(1, fId);
            // execute
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps);
        }
        return res;
    }
}

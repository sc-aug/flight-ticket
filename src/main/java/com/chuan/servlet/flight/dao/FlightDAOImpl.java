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
        String query = "SELECT " +
                "    flight_id, " +
                "    relative_departure_time, " +
                "    relative_arrival_time, " +
                "    l1.location_id, " +
                "    l2.location_id, " +
                "    a.airplane_id, " +
                "    l1.location_name, " +
                "    l2.location_name, " +
                "    airplane_name " +
                "FROM ( " +
                "    SELECT * FROM flight " +
                "    WHERE flight_id = ?) f " +
                "LEFT JOIN location l1 " +
                "ON f.departure_loc_id = l1.location_id " +
                "LEFT JOIN location l2 " +
                "ON f.arrival_loc_id = l2.location_id " +
                "LEFT JOIN airplane a " +
                "ON f.airplane_id = a.airplane_id";
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            ps.setInt(1, fId);
            rs = ps.executeQuery();
            if(rs.next()) {
                flight = new FlightBean(
                        rs.getInt(1),
                        rs.getTimestamp(2).toLocalDateTime(),
                        rs.getTimestamp(3).toLocalDateTime(),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)
                );
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
        String query = "SELECT " +
                "    flight_id, " +
                "    relative_departure_time, " +
                "    relative_arrival_time, " +
                "    l1.location_id, " +
                "    l2.location_id, " +
                "    a.airplane_id, " +
                "    l1.location_name, " +
                "    l2.location_name, " +
                "    airplane_name " +
                "FROM flight f " +
                "LEFT JOIN location l1 " +
                "ON f.departure_loc_id = l1.location_id " +
                "LEFT JOIN location l2 " +
                "ON f.arrival_loc_id = l2.location_id " +
                "LEFT JOIN airplane a " +
                "ON f.airplane_id = a.airplane_id " +
                "ORDER BY flight_id";
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                fl.add(new FlightBean(
                        rs.getInt(1),
                        rs.getTimestamp(2).toLocalDateTime(),
                        rs.getTimestamp(3).toLocalDateTime(),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps, rs);
        }
        return fl;
    }
}

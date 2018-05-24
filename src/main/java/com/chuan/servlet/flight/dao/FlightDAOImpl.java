package com.chuan.servlet.flight.dao;

import com.chuan.servlet.flight.bean.FlightBean;
import com.chuan.servlet.flight.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDAOImpl implements FlightDAO {
    @Override
    public boolean addFlight(FlightBean f) {
        return false;
    }

    @Override
    public boolean getFlightById(int fId) {
        return false;
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
                "    c1.city_name, " +
                "    c2.city_name, " +
                "    a.airplane_name " +
                "FROM flight f " +
                "LEFT JOIN city c1 " +
                "ON f.departure_city_id = c1.city_id " +
                "LEFT JOIN city c2 " +
                "ON f.arrival_city_id = c2.city_id " +
                "LEFT JOIN airplane a " +
                "ON f.airplane_id = a.airplane_id";
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                fl.add(new FlightBean(
                        rs.getInt(1),
                        rs.getTimestamp(2).toLocalDateTime(),
                        rs.getTimestamp(3).toLocalDateTime(),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
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

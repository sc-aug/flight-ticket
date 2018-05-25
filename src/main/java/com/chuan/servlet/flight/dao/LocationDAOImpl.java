package com.chuan.servlet.flight.dao;

import com.chuan.servlet.flight.bean.LocationBean;
import com.chuan.servlet.flight.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationDAOImpl implements LocationDAO {

    @Override
    public List<LocationBean> getAllLocations() {
        Connection con = null;
        PreparedStatement ps = null;
        List<LocationBean> ll = new ArrayList<LocationBean>();
        ResultSet rs = null;
        String query = "SELECT * FROM location ORDER BY location_id";
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                ll.add(new LocationBean(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps, rs);
        }
        return ll;
    }

    @Override
    public LocationBean getLocationById(int locId) {
        Connection con = null;
        PreparedStatement ps = null;
        LocationBean loc = null;
        ResultSet rs = null;
        String query = "SELECT * FROM location WHERE location_id = ?";
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            ps.setInt(1, locId);
            rs = ps.executeQuery();
            if (rs.next()) {
                loc = new LocationBean(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps, rs);
        }
        return loc;
    }

    @Override
    public int updateLocation(LocationBean loc) {
        Connection con = null;
        PreparedStatement ps = null;
        int res = -1;
        String query = "UPDATE location SET " +
                "location_name = ?, " +
                "timezone = ? " +
                "WHERE location_id = ?";
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            ps.setString(1, loc.getLocationName());
            ps.setString(2, loc.getTimezone());
            ps.setInt(3, loc.getLocationId());
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps);
        }
        return res;
    }

    @Override
    public int deleteLocation(int locId) {
        Connection con = null;
        PreparedStatement ps = null;
        int res = -1;
        String query = "DELETE FROM location WHERE location_id = ?";
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            ps.setInt(1, locId);
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps);
        }
        return res;
    }
}

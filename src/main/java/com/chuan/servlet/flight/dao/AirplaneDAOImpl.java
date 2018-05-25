package com.chuan.servlet.flight.dao;

import com.chuan.servlet.flight.bean.AirplaneBean;
import com.chuan.servlet.flight.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneDAOImpl implements AirplaneDAO {

    @Override
    public AirplaneBean getAirplaneById(int airplaneId) {
        Connection con = null;
        PreparedStatement ps = null;
        AirplaneBean airplane = null;
        ResultSet rs = null;
        String query = "SELECT * " +
                "FROM airplane " +
                "WHERE airplane_id = ?";
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            ps.setInt(1, airplaneId);
            rs = ps.executeQuery();
            if (rs.next()) {
                airplane = new AirplaneBean(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps, rs);
        }
        return airplane;
    }

    @Override
    public List<AirplaneBean> getAllAirplanes() {
        Connection con = null;
        PreparedStatement ps = null;
        List<AirplaneBean> al = new ArrayList<AirplaneBean>();
        ResultSet rs = null;
        String query = "SELECT * FROM airplane";
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                al.add(new AirplaneBean(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps, rs);
        }
        return al;
    }

}

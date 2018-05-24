package com.chuan.servlet.flight.dao;

import com.chuan.servlet.flight.bean.SeatTypeBean;
import com.chuan.servlet.flight.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatTypeDAOImpl implements SeatTypeDAO {
    @Override
    public List<SeatTypeBean> getAllSeatTypes() {
        Connection con = null;
        PreparedStatement ps = null;
        List<SeatTypeBean> stl = new ArrayList<SeatTypeBean>();
        ResultSet rs = null;
        String query = "SELECT " +
                "    seat_type_id, " +
                "    seat_type_name " +
                "FROM seat_type";
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                stl.add(new SeatTypeBean(
                        rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps, rs);
        }
        return stl;
    }
}

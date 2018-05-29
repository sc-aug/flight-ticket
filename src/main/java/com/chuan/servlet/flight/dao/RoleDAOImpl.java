package com.chuan.servlet.flight.dao;

import com.chuan.servlet.flight.bean.RoleBean;
import com.chuan.servlet.flight.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAOImpl implements RoleDAO {
    @Override
    public List<RoleBean> getAllRoles() {
        Connection con = null;
        PreparedStatement ps = null;
        List<RoleBean> rl = new ArrayList<RoleBean>();
        ResultSet rs = null;
        String query = "SELECT * FROM role ORDER BY role_id";
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                rl.add(new RoleBean(
                        rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps, rs);
        }
        return rl;
    }

    @Override
    public RoleBean getRoleById(int rId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        RoleBean r = null;
        String query = "SELECT * FROM role WHERE role_id = ?";
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            ps.setInt(1, rId);
            rs = ps.executeQuery();
            if (rs.next()) {
                r = new RoleBean(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps, rs);
        }
        return r;
    }

    @Override
    public int updateRole(RoleBean role) {
        Connection con = null;
        PreparedStatement ps = null;
        int res = -1;
        RoleBean r = null;
        String query = "UPDATE role " +
                "SET role_name = ? " +
                "WHERE role_id = ?";
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            ps.setString(1, role.getRoleName());
            ps.setInt(2, role.getRoleId());
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps);
        }
        return res;
    }
}

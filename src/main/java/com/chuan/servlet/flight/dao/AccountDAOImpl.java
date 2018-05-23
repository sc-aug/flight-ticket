package com.chuan.servlet.flight.dao;

import com.chuan.servlet.flight.bean.AccountBean;
import com.chuan.servlet.flight.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

    @Override
    public AccountBean loginAccount(AccountBean acc) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AccountBean retAcc = null;
        String query = "SELECT * FROM account " +
                "WHERE username = ? AND password = ?";
        try {
            con = DBUtil.getConnectionObject();
            ps = DBUtil.getPreparedStatement(con, query);
            ps = con.prepareStatement(query);
            ps.setString(1, acc.getUsername());
            ps.setString(2, acc.getPassword());
            rs = ps.executeQuery();

            if(rs.next()) {
                retAcc = new AccountBean(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps);
        }
        return retAcc;
    }

    @Override
    public int addAccount(AccountBean acc) {
        Connection con = null;
        PreparedStatement ps = null;
        int res = -1;
        String query = "INSERT INTO account VALUES (DEFAULT, ?, ?, ?)";
        try {
            con = DBUtil.getConnectionObject();
            ps = DBUtil.getPreparedStatement(con, query);
            ps = con.prepareStatement(query);
            ps.setString(1, acc.getUsername());
            ps.setString(2, acc.getPassword());
            ps.setInt(3, acc.getRoleId());
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps);
        }
        return res;
    }

    @Override
    public int deleteAccountById(int accId) {
        Connection con = null;
        PreparedStatement ps = null;
        int res = -1;
        String query = "DELETE FROM account WHERE uid = ?";
        try {
            con = DBUtil.getConnectionObject();
            ps = DBUtil.getPreparedStatement(con, query);
            ps = con.prepareStatement(query);
            ps.setInt(1, accId);
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps);
        }
        return res;
    }

    @Override
    public int updateAccount(AccountBean acc) {
        Connection con = null;
        PreparedStatement ps = null;
        int res = -1;
        String query = "UPDATE account SET " +
                "username = ?, password = ? WHERE uid = ?";
        try {
            con = DBUtil.getConnectionObject();
            ps = DBUtil.getPreparedStatement(con, query);
            ps = con.prepareStatement(query);
            ps.setString(1, acc.getUsername());
            ps.setString(2, acc.getPassword());
            ps.setInt(3, 1);
            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps);
        }
        return res;
    }

    @Override
    public List<AccountBean> getAllAccounts() {
        Connection con = null;
        PreparedStatement ps = null;
        List<AccountBean> al = new ArrayList<AccountBean>();
        ResultSet rs = null;
        String query = "SELECT * FROM account";
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                al.add(new AccountBean(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps, rs);
        }
        return al;
    }

    @Override
    public AccountBean getAccountById(int accId) {
        Connection con = null;
        PreparedStatement ps = null;
        AccountBean acc = null;
        ResultSet rs = null;
        String query = "SELECT * FROM account WHERE uid = ?";
        try {
            con = DBUtil.getConnectionObject();
            ps = con.prepareStatement(query);
            ps.setInt(1, accId);
            rs = ps.executeQuery();
            if(rs.next()) {
                acc = new AccountBean(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeDbResources(con, ps, rs);
        }
        return acc;
    }
}

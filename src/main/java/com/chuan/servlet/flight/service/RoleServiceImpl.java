package com.chuan.servlet.flight.service;

import com.chuan.servlet.flight.bean.RoleBean;
import com.chuan.servlet.flight.dao.RoleDAOImpl;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    @Override
    public List<RoleBean> getAllRoles() {
        return new RoleDAOImpl().getAllRoles();
    }

    @Override
    public RoleBean getRoleById(int rId) {
        return new RoleDAOImpl().getRoleById(rId);
    }

    @Override
    public int updateRole(RoleBean role) {
        return new RoleDAOImpl().updateRole(role);
    }
}

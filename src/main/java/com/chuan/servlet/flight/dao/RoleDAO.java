package com.chuan.servlet.flight.dao;

import com.chuan.servlet.flight.bean.RoleBean;

import java.util.List;

public interface RoleDAO {
    // get all roles
    public List<RoleBean> getAllRoles();
    // get role by id
    public RoleBean getRoleById(int rId);
    // update role
    public int updateRole(RoleBean role);
}

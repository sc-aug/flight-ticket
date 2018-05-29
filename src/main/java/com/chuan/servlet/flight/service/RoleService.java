package com.chuan.servlet.flight.service;

import com.chuan.servlet.flight.bean.RoleBean;

import java.util.List;

public interface RoleService {
    // get all roles
    public List<RoleBean> getAllRoles();
    // get role by id
    public RoleBean getRoleById(int rId);
    // update role
    public int updateRole(RoleBean role);
}

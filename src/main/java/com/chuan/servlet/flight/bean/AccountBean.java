package com.chuan.servlet.flight.bean;

public class AccountBean {
    private int uId;
    private String username;
    private String password;
    private int roleId;
    private String roleName;

    public AccountBean() { }

    public AccountBean(String u, String p) {
        username = u;
        password = p;
    }

    public AccountBean(int i, String u, String p, int r) {
        uId = i;
        username = u;
        password = p;
        roleId = r;
    }

    public AccountBean(int i, String u, String p, int r, String rn) {
        uId = i;
        username = u;
        password = p;
        roleId = r;
        roleName = rn;
    }

    public int getUId() {
        return uId;
    }

    public void setUId(int uId) {
        this.uId = uId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

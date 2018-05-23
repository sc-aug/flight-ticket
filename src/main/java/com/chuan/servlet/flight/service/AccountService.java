package com.chuan.servlet.flight.service;

import com.chuan.servlet.flight.bean.AccountBean;

import java.util.List;

public interface AccountService {
    // login
    public AccountBean login(AccountBean acc);
    // register
    public boolean register(AccountBean acc);
    // get all user
    public List<AccountBean> getAllAccounts();
}

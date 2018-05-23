package com.chuan.servlet.flight.service;

import com.chuan.servlet.flight.bean.AccountBean;

public interface AccountService {
    // login
    public AccountBean login(AccountBean acc);
    // register
    public boolean register(AccountBean acc);
}

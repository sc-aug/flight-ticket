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
    // delete account by id
    public int deleteAccountById(int uid);
    // get account by id
    public AccountBean getAccountById(int uid);
    // update account
    public int updateAccount(AccountBean acc);
}

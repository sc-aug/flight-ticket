package com.chuan.servlet.flight.service;

import com.chuan.servlet.flight.bean.AccountBean;
import com.chuan.servlet.flight.dao.AccountDAO;
import com.chuan.servlet.flight.dao.AccountDAOImpl;

public class AccountServiceImpl implements AccountService {

    @Override
    public AccountBean login(AccountBean acc) {
        AccountDAO accDao = new AccountDAOImpl();
        return accDao.loginAccount(acc);
    }

    @Override
    public boolean register(AccountBean acc) {
        AccountDAO accDao = new AccountDAOImpl();
        return accDao.addAccount(acc) != -1;
    }
}

package com.chuan.servlet.flight.service;

import com.chuan.servlet.flight.bean.AccountBean;
import com.chuan.servlet.flight.dao.AccountDAOImpl;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    @Override
    public AccountBean login(AccountBean acc) {
        return new AccountDAOImpl().loginAccount(acc);
    }

    @Override
    public boolean register(AccountBean acc) {
        return new AccountDAOImpl().addAccount(acc) != -1;
    }

    @Override
    public List<AccountBean> getAllAccounts() {
        return new AccountDAOImpl().getAllAccounts();
    }

}

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
    public int newAccount(AccountBean acc) {
        return new AccountDAOImpl().addAccount(acc);
    }

    @Override
    public List<AccountBean> getAllAccounts() {
        return new AccountDAOImpl().getAllAccounts();
    }

    @Override
    public int deleteAccountById(int uid) {
        return new AccountDAOImpl().deleteAccountById(uid);
    }

    @Override
    public AccountBean getAccountById(int uId) {
        return new AccountDAOImpl().getAccountById(uId);
    }

    @Override
    public int updateAccount(AccountBean acc) {
        return new AccountDAOImpl().updateAccount(acc);
    }

}

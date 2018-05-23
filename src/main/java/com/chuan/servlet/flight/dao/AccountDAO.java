package com.chuan.servlet.flight.dao;

import com.chuan.servlet.flight.bean.AccountBean;

import java.util.List;

public interface AccountDAO {

    public AccountBean loginAccount(AccountBean acc);

    public int addAccount(AccountBean acc);

    public int deleteAccountById(int accId);

    public int updateAccount(AccountBean acc);

    public List<AccountBean> getAllAccounts();

    public AccountBean getAccountById(int accId);

}

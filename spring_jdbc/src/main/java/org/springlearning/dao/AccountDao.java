package org.springlearning.dao;

import org.springlearning.po.Account;

import java.util.List;

public interface AccountDao {

    public int addAccount(Account account);
    public int addAccountGetKey(Account account);
    public int addAccountBatch(List<Account> accounts);
    int queryAccountCount(Integer userId);
    public Account queryAccountById(Integer accountId);
    public List<Account> queryAccountsByParams(Integer userId, String accountName,
                                               String accountType, String createTime);
    public int updateAccountById(Account account);
    public int updateAccountBatch(List<Account> accounts);
    public Integer deleteAccountById(Integer accountId);
    public int deleteAccountBatch(Integer[] idArr);

}

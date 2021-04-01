package org.springlearning.test;

import org.junit.Test;
import org.springlearning.dao.AccountDao;
import org.springlearning.po.Account;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class SpringJdbcQueryTest extends BasicTest{

    @Resource
    private AccountDao accountDao;

    @Test
    public void queryAccountByIdTest() {
        Account account = accountDao.queryAccountById(1);
        System.out.println("account: " + account);
    }

    @Test
    public void testQueryAccountByParams(){

        List<Account> accountList01 = accountDao.queryAccountsByParams(3,null,null,null);
        List<Account> accountList02 = accountDao.queryAccountsByParams(3,"A",null,null);
        System.out.println(accountList01.toString());
        System.out.println(accountList02.toString());
    }

}

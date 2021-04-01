package org.springlearning.test;

import org.junit.Test;
import org.springlearning.dao.AccountDao;
import org.springlearning.po.Account;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class SpringJdbcAddTest extends BasicTest{

    @Resource
    private AccountDao accountDao;

    @Test
    public void addAccountTest() {
        Account account = new Account("Tom","CCB",100.0,"pocket money",1);
        int row = accountDao.addAccount(account);
        System.out.println("Account added: " + row);
    }

    @Test
    public void testAddAccountGetKey() {
        Account account = new Account("Jerry","ICBC",200.0,"pocket money",2);
        int key = accountDao.addAccountGetKey(account);
        System.out.println("The key after an account was added: " + key);
    }

    @Test
    public void testAddAccountBatch() {
        Account account = new Account("AA","CCB",2000.0,"",3);
        Account account2 = new Account("BB","ICBC",280.0,"",3);
        Account account3 = new Account("CC","ABC",800.0,"",3);
        List<Account> accountList = new ArrayList<>();
        accountList.add(account);
        accountList.add(account2);
        accountList.add(account3);

        int rows = accountDao.addAccountBatch(accountList);
        System.out.println("Accounts added: " + rows);
    }


    @Test
    public void testDeleteAccountBatch(){

        Integer[] ids = new Integer[]{2, 3};
        int rows = accountDao.deleteAccountBatch(ids);
        System.out.println("rows deleted： " + rows);
    }
}

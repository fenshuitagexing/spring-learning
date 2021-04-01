package org.springlearning.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springlearning.dao.AccountDao;
import org.springlearning.po.Account;

import javax.annotation.Resource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addAccount(Account account) {

        String sql = "INSERT INTO tb_account(account_name,account_type,money,remark," +
                     "user_id,create_time,update_time) VALUES (?,?,?,?,?,now(),now())";
        Object[] objArr= { account.getAccountName(), account.getAccountType(),
                             account.getMoney(), account.getRemark(), account.getUserId() };
        return jdbcTemplate.update(sql, objArr);
    }

    @Override
    public int addAccountGetKey(Account account) {
        String sql = "INSERT INTO tb_account(account_name,account_type,money,remark," +
                "user_id,create_time,update_time) VALUES (?,?,?,?,?,now(),now())";

        // Acquire the primary key of the record
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, account.getAccountName());
            ps.setString(2, account.getAccountType());
            ps.setDouble(3, account.getMoney());
            ps.setString(4, account.getRemark());
            ps.setInt(5, account.getUserId());

            return ps;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public int addAccountBatch(List<Account> accounts) {
        String sql = "INSERT INTO tb_account(account_name,account_type,money,remark," +
                "user_id,create_time,update_time) VALUES (?,?,?,?,?,now(),now())";

        int rows = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {

                Account account = accounts.get(i);

                ps.setString(1, account.getAccountName());
                ps.setString(2, account.getAccountType());
                ps.setDouble(3, account.getMoney());
                ps.setString(4, account.getRemark());
                ps.setInt(5, account.getUserId());
            }

            @Override
            public int getBatchSize() {
                return accounts.size();
            }
        }).length;

        return rows;
    }

    @Override
    public int queryAccountCount(Integer userId) {
        return 0;
    }

    @Override
    public Account queryAccountById(Integer accountId) {

        String sql = "SELECT * FROM tb_account WHERE account_id = ?";

        Account account = jdbcTemplate.queryForObject(sql, (resultSet, rowNum) -> {
            Account acc = new Account();

            acc.setAccountId(accountId);
            acc.setMoney(resultSet.getDouble("money"));
            acc.setAccountName(resultSet.getString("account_name"));
            acc.setAccountType(resultSet.getString("account_type"));
            acc.setRemark(resultSet.getString("remark"));
            acc.setCreateTime(resultSet.getDate("create_time"));
            acc.setUpdateTime(resultSet.getDate("update_time"));
            acc.setUserId(resultSet.getInt("user_id"));

            return acc;
        }, accountId);

        return account;
    }

    @Override
    public List<Account> queryAccountsByParams(Integer userId, String accountName, String accountType, String createTime) {

        String sql = "SELECT * FROM tb_account WHERE user_id = ?";

        List<Object> params = new ArrayList<>();
        params.add(userId);

        if (StringUtils.isNotBlank(accountName)) {
            sql += " AND account_name LIKE CONCAT('%', ?, '%')";
            params.add(accountName);
        }

        if (StringUtils.isNotBlank(accountType)) {
            sql += " AND account_type = ? ";
            params.add(accountType);
        }

        if (StringUtils.isNotBlank(createTime)) {
            sql += " AND create_time > ? ";
            params.add(createTime);
        }

        Object[] objArr = params.toArray();

        List<Account> accountList = jdbcTemplate.query(sql, objArr, (resultSet, rowNum) -> {
            Account acc = new Account();

            acc.setAccountId(resultSet.getInt("account_id"));
            acc.setMoney(resultSet.getDouble("money"));
            acc.setAccountName(resultSet.getString("account_name"));
            acc.setAccountType(resultSet.getString("account_type"));
            acc.setRemark(resultSet.getString("remark"));
            acc.setCreateTime(resultSet.getTimestamp("create_time"));
            acc.setUpdateTime(resultSet.getTimestamp("update_time"));
            acc.setUserId(resultSet.getInt("user_id"));

            return acc;
        });

        return accountList;
    }

    @Override
    public int updateAccountById(Account account) {
        return 0;
    }

    @Override
    public int updateAccountBatch(List<Account> accounts) {
        return 0;
    }

    @Override
    public Integer deleteAccountById(Integer accountId) {
        return null;
    }

    @Override
    public int deleteAccountBatch(Integer[] idArr) {

        String sql = "DELETE FROM tb_account WHERE account_id = ?";

        int rows = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, idArr[i]);
            }

            @Override
            public int getBatchSize() {
                return idArr.length;
            }
        }).length;

        return rows;
    }
}

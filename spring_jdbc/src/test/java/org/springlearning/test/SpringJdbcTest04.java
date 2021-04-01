package org.springlearning.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


public class SpringJdbcTest04 extends BasicTest{

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testJdbc01() {

        String sql = "SELECT count(1) FROM tb_account";
        Integer num = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("num: " + num);
    }

    @Test
    public void testJdbc02() {

        String sql = "SELECT count(1) FROM tb_account WHERE user_id = ?";
        Integer num = jdbcTemplate.queryForObject(sql, Integer.class, 2);
        System.out.println("num: " + num);
    }
}

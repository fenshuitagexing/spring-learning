package org.springlearning.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

// SpringJUnit4ClassRunner Enables developers to implement integration tests for Spring components
// like controllers and Repositories
@RunWith(SpringJUnit4ClassRunner.class)

// Indicates which XML files contain ApplicationContext
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class SpringJdbcTest03 {

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

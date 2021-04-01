package org.springlearning.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringJdbcTest01 {

    @Test
    public void testJdbc01() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

        JdbcTemplate jdbcTemplate = (JdbcTemplate) ac.getBean("jdbcTemplate");

        String sql = "SELECT count(1) FROM tb_account";
        Integer num = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("num: " + num);
    }

    @Test
    public void testJdbc02() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

        JdbcTemplate jdbcTemplate = (JdbcTemplate) ac.getBean("jdbcTemplate");

        String sql = "SELECT count(1) FROM tb_account WHERE user_id = ?";
        Integer num = jdbcTemplate.queryForObject(sql, Integer.class, 2);
        System.out.println("num: " + num);
    }
}

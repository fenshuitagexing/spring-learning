package org.springlearning;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springlearning.dao.CustomerDao;
import org.springlearning.domain.Customer;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class CustomerDaoTest {

    @Resource
    private CustomerDao customerDao;

    @Test
    public void testFindOne() {
        Customer customer = customerDao.findOne(2L);
        System.out.println(customer);
    }

    /**
     * findOne():
     *      em.find() -- eager loading
     *
     * getOne():
     *      em.getReference() -- lazy loading
     */
    @Test
    @Transactional
    public void testGetOne() {
        Customer customer = customerDao.getOne(2L);
        System.out.println(customer);
    }

    /**
     * save : insert or update
     *        depends on whether ID is specified，
     */
    @Test
    public void testSave() {
        Customer customer = new Customer();
        customer.setCustName("Microsoft");
        customer.setCustLevel("vip");
        customer.setCustIndustry("IT");
        customerDao.save(customer);
    }

    @Test
    public void testUpdate() {
        Customer customer  = new Customer();
        customer.setCustId(12L);
        customer.setCustName("LG");
        customerDao.save(customer);
    }

    @Test
    public void testDelete () {
        customerDao.delete(11L);
    }

    @Test
    public void testFindAll() {
        List<Customer> list = customerDao.findAll();
        for(Customer customer : list) {
            System.out.println(customer);
        }
    }
}

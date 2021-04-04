package org.springlearning;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springlearning.dao.CustomerDao;
import org.springlearning.domain.Customer;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class JpqlTest {

    @Resource
    private CustomerDao customerDao;

    @Test
    public void testFindByNameJpql() {
        Customer customer = customerDao.findCustomerByNameWithJpql("LG");
        System.out.println(customer);
    }

    @Test
    public void testFindByNameAndIdJpql() {
        Customer customer = customerDao.findCustomerByNameAndIdWithJpql(2L, "Intel");
        System.out.println(customer);
    }

    /**
     * @Transactional is required
     * By default, it rolls back, so set @Rollback as false
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void tesUpdateByNameAndIdJpql() {
        customerDao.updateCustomerByNameAndIdWithJpql(6L, "Oracle");
    }


    @Test
    public void testFindBySql() {
        List<Object[]> customerList = customerDao.findBySql("%n%");
        for (Object[] obj : customerList) {
            System.out.println(Arrays.toString(obj));
        }
    }

    @Test
    public void testFindByCustName() {
        Customer customer = customerDao.findByCustName("LG");
        System.out.println(customer);
    }

}

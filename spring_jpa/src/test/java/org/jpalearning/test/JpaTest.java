package org.springlearning.test;

import org.junit.Test;
import org.springlearning.domain.Customer;
import org.springlearning.utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

    /**
     * Steps:
     * 1. Load the configuration file to create factory(entity manager class) object
     * 2. Acquire entity manager from the factory
     * 3. Acquire transaction object to enable transaction
     * 4. Perform CRUD
     * 5. Commit / Rollback
     * 6. Release the resources
     */
    @Test
    public void testSave() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");

        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Customer customer = new Customer();
        customer.setCustName("Intel");
        customer.setCustIndustry("IC");

        entityManager.persist(customer);

        transaction.commit();

        entityManager.close();
        factory.close();
    }

    @Test
    public void testSaveByStaticFactory() {

        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Customer customer = new Customer();
        customer.setCustName("Nokia");
        customer.setCustIndustry("ICT");

        entityManager.persist(customer);

        transaction.commit();

        entityManager.close();
    }


    @Test
    public void testFind() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = entityManager.find(Customer.class, 1L);
        System.out.println(customer);

        transaction.commit();
        entityManager.close();
    }

    /**
     * A dynamic proxy object is returned
     * Only when the object to be find in database is used, the SQL statement will be sent
     * Lazy loading
     */
    @Test
    public void testReference() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = entityManager.getReference(Customer.class, 1L);
        System.out.println(customer);

        transaction.commit();
        entityManager.close();
    }

    @Test
    public void testRemove() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = entityManager.find(Customer.class, 1L);
        entityManager.remove(customer);

        transaction.commit();
        entityManager.close();
    }

    @Test
    public void testUpdate() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = entityManager.find(Customer.class, 2L);
        customer.setCustIndustry("IT");
        entityManager.merge(customer);

        transaction.commit();
        entityManager.close();
    }
}

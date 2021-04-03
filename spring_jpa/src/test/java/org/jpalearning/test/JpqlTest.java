package org.springlearning.test;

import org.junit.Test;
import org.springlearning.utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JpqlTest {

    @Test
    public void testFindAll() {

        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String jpql = "FROM org.springlearning.domain.Customer ORDER BY custId DESC";
        Query query = entityManager.createQuery(jpql);

        List resultList = query.getResultList();
        for (Object obj : resultList) {
            System.out.println(obj);
        }

        transaction.commit();

        entityManager.close();
    }

    @Test
    public void testCount() {

        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String jpql = "SELECT COUNT(custId) FROM Customer";
        Query query = entityManager.createQuery(jpql);

        List resultList = query.getResultList();
        for (Object obj : resultList) {
            System.out.println(obj);
        }

        transaction.commit();

        entityManager.close();
    }

    @Test
    public void testPaged() {

        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String jpql = "FROM Customer";
        Query query = entityManager.createQuery(jpql);
        query.setFirstResult(0);
        query.setMaxResults(2);

        List resultList = query.getResultList();
        for (Object obj : resultList) {
            System.out.println(obj);
        }

        transaction.commit();

        entityManager.close();
    }

    @Test
    public void testCondition() {

        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String jpql = "FROM Customer WHERE custName LIKE ?";
        Query query = entityManager.createQuery(jpql);
        query.setParameter(1, "%n%");
        query.setFirstResult(0);
        query.setMaxResults(2);

        List resultList = query.getResultList();
        for (Object obj : resultList) {
            System.out.println(obj);
        }

        transaction.commit();

        entityManager.close();
    }
}

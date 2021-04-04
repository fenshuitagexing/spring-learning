package org.springlearning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springlearning.domain.Customer;

import java.util.List;

/**
 *  To conform the specification of DAO layer of Spring Data JPA:
 *      JpaRepository<(The Entity class), (The type of primary key of the entity class)>
 *          Encapsulates basic CRUD operations
 *      JpaSpecificationExecutor<The Entity class>
 *          Encapsulates complex queries
 */
public interface CustomerDao extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    @Query(value = "FROM Customer WHERE custName = ?")
    Customer findCustomerByNameWithJpql(String custName);

    @Query(value = "FROM Customer WHERE custName = ?2 AND custId = ?1")
    Customer findCustomerByNameAndIdWithJpql(Long id, String name);

    @Query(value = "UPDATE Customer SET custName = ?2 WHERE custId = ?1")
    @Modifying
    void updateCustomerByNameAndIdWithJpql(Long id, String name);

    @Query(value = "SELECT * FROM cst_customer WHERE cust_name LIKE ?1", nativeQuery = true)
    public List<Object[]> findBySql(String name);

    // Method naming conventions
    Customer findByCustName(String custName);
}

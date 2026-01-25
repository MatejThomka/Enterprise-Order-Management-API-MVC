package com.mth.spring.mvc.ordermanagement.repository;

import com.mth.spring.mvc.ordermanagement.model.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Customer entity operations. Provides CRUD operations and custom queries
 * for customers.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  /**
   * Finds a customer by their email address.
   *
   * @param email the email address to search for
   * @return an Optional containing the customer if found, empty otherwise
   */
  Optional<Customer> findByEmail(String email);

  /**
   * Checks if a customer exists with the given email address.
   *
   * @param email the email address to check
   * @return true if a customer with the email exists, false otherwise
   */
  boolean existsByEmail(String email);
}

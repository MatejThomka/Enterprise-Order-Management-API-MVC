package com.mth.spring.mvc.ordermanagement.repository;

import com.mth.spring.mvc.ordermanagement.model.Order;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Order entity operations. Provides CRUD operations and custom queries
 * for orders.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

  /**
   * Finds an order by its order number.
   * @param orderNumber the unique order number
   * @return an Optional containing the order if found, empty otherwise
   */
  Optional<Order> findByOrderNumber(String orderNumber);

  /**
   * Checks if an order exists with the given order number.
   * @param orderNumber the unique order number
   * @return true if an order with the order number exists, false otherwise
   */
  boolean existByOrderNumber(String orderNumber);

  /**
   * Finds orders by the associated customer ID with pagination support.
   * @param customerId the ID of the customer
   * @param pageable pagination information
   * @return a page of orders associated with the specified customer ID
   */
  Page<Order> findByCustomerId(Long customerId, Pageable pageable);
}

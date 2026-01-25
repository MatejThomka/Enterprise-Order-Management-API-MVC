package com.mth.spring.mvc.ordermanagement.repository;

import com.mth.spring.mvc.ordermanagement.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Item entity operations. Provides CRUD operations and custom queries for
 * items.
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

  /**
   * Finds items by the associated order ID with pagination support.
   *
   * @param orederId the ID of the order
   * @param pageable pagination information
   * @return a page of items associated with the specified order ID
   */
  Page<Item> findByOrderId(Long orederId, Pageable pageable);
}

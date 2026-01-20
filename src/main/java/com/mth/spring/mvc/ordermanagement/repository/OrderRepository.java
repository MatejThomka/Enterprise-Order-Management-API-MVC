package com.mth.spring.mvc.ordermanagement.repository;

import com.mth.spring.mvc.ordermanagement.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}

package com.mth.spring.mvc.ordermanagement.repository;

import com.mth.spring.mvc.ordermanagement.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {}

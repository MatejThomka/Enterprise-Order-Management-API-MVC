package com.mth.spring.mvc.ordermanagement.model;

import java.time.Instant;
import java.util.List;
import org.springframework.data.annotation.Id;

public record Order(
    @Id Long id,
    String name,
    Instant orderedAt,
    String orderDescription,
    List<Item> orderedItems) {}

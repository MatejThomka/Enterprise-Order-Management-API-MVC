package com.mth.spring.mvc.ordermanagement.dto.request;

import java.math.BigDecimal;

/**
 * Data transfer object for creating an item
 *
 * @param name the name of the item
 * @param description the description of the item
 * @param price the price of the item
 */
public record CreateItemRequest(String name, String description, BigDecimal price) {}

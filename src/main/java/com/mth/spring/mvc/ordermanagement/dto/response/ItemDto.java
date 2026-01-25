package com.mth.spring.mvc.ordermanagement.dto.response;

import java.math.BigDecimal;

/**
 * Data transfer object for item response
 *
 * @param id the unique identifier of the item
 * @param name the name of the item
 * @param description the description of the item
 * @param price the price of the item
 */
public record ItemDto(Long id, String name, String description, BigDecimal price) {}

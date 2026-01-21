package com.mth.spring.mvc.ordermanagement.dto.request;

import java.math.BigDecimal;

public record CreateItemRequest(String name, String description, BigDecimal price) {}

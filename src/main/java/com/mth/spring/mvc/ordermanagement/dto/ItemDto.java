package com.mth.spring.mvc.ordermanagement.dto;

import java.math.BigDecimal;

public record ItemDto(Long id, String name, String description, BigDecimal price) {}

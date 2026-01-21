package com.mth.spring.mvc.ordermanagement.dto.response;

import java.math.BigDecimal;

public record ItemDto(Long id, String name, String description, BigDecimal price) {}

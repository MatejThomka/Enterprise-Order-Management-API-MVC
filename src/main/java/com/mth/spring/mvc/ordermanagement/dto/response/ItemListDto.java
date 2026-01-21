package com.mth.spring.mvc.ordermanagement.dto.response;

import java.math.BigDecimal;

public record ItemListDto(Long id, String name, BigDecimal price) {}
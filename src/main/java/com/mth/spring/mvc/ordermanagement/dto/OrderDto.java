package com.mth.spring.mvc.ordermanagement.dto;

import com.mth.spring.mvc.ordermanagement.model.OrderStatus;
import java.time.Instant;
import java.util.List;

public record OrderDto(
    String orderNumber,
    OrderStatus status,
    CustomerSummaryDto customer,
    List<ItemListDto> items,
    Instant createdAt) {}

package com.mth.spring.mvc.ordermanagement.dto.response;

import com.mth.spring.mvc.ordermanagement.model.OrderStatus;
import java.time.Instant;

public record OrderListDto(String orderNumber, OrderStatus status, Instant createdAt) {}

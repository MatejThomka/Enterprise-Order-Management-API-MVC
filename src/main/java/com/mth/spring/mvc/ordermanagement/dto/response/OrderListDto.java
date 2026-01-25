package com.mth.spring.mvc.ordermanagement.dto.response;

import com.mth.spring.mvc.ordermanagement.model.OrderStatus;
import java.time.Instant;

/**
 * Data transfer object for order list response
 *
 * @param orderNumber the unique order number
 * @param status the status of the order
 * @param createdAt the timestamp when the order was created
 */
public record OrderListDto(String orderNumber, OrderStatus status, Instant createdAt) {}

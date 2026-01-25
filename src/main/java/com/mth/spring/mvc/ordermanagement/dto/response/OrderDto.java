package com.mth.spring.mvc.ordermanagement.dto.response;

import com.mth.spring.mvc.ordermanagement.model.OrderStatus;
import java.time.Instant;
import java.util.List;

/**
 * Data transfer object for order response
 *
 * @param orderNumber the unique order number
 * @param status the status of the orderF
 * @param customer the customer associated with the order
 * @param items the list of items in the order
 * @param createdAt the timestamp when the order was created
 */
public record OrderDto(
    String orderNumber,
    OrderStatus status,
    CustomerSummaryDto customer,
    List<ItemListDto> items,
    Instant createdAt) {}

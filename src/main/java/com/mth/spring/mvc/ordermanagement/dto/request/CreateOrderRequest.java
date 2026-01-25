package com.mth.spring.mvc.ordermanagement.dto.request;

import java.util.List;

/**
 * Data transfer object for creating a new order
 *
 * @param customer the customer information for the new order
 * @param items the list of items to be included in the new order
 */
public record CreateOrderRequest(CreateCustomerRequest customer, List<CreateItemRequest> items) {}

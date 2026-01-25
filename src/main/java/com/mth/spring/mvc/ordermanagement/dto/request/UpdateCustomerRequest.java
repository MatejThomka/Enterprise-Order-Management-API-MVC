package com.mth.spring.mvc.ordermanagement.dto.request;

/**
 * Data transfer object for updating a customer's information
 *
 * @param firstName the customer's first name
 * @param lastName the customer's last name
 * @param phoneNumber the customer's phone number
 */
public record UpdateCustomerRequest(String firstName, String lastName, String phoneNumber) {}

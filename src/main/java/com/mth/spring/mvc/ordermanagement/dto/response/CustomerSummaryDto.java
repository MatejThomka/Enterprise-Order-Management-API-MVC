package com.mth.spring.mvc.ordermanagement.dto.response;

/**
 * Data Transfer Object for customer summary response data. Contains a subset of the customer's
 * information.
 *
 * @param id the customer's unique identifier
 * @param firstName the customer's first name
 * @param lastName the customer's last name
 * @param email the customer's email address
 */
public record CustomerSummaryDto(Long id, String firstName, String lastName, String email) {}

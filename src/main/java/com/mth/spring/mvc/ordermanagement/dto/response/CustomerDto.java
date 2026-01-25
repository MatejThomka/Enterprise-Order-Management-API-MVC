package com.mth.spring.mvc.ordermanagement.dto.response;

/**
 * Data Transfer Object for customer response data. Contains the customer's basic information.
 *
 * @param id the customer's unique identifier
 * @param firstName the customer's first name
 * @param lastName the customer's last name
 * @param email the customer's email address
 * @param phoneNumber the customer's phone number
 */
public record CustomerDto(
    Long id, String firstName, String lastName, String email, String phoneNumber) {}

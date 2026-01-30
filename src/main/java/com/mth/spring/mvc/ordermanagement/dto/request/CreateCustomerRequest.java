package com.mth.spring.mvc.ordermanagement.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * Data transfer object for creating a customer
 *
 * @param firstName the customer's first name
 * @param lastName the customer's last name
 * @param email the customer's email address
 * @param phoneNumber the customer's phone number
 */
public record CreateCustomerRequest(
    @NotBlank String firstName,
    @NotBlank String lastName,
    @NotBlank @Email String email,
    String phoneNumber) {}

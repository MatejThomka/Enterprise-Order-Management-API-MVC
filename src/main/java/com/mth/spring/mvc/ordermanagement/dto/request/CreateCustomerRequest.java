package com.mth.spring.mvc.ordermanagement.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateCustomerRequest(
    @NotBlank String firstName,
    @NotBlank String lastName,
    @Email String email,
    String phoneNumber
) {
    
}

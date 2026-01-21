package com.mth.spring.mvc.ordermanagement.mapper;

import com.mth.spring.mvc.ordermanagement.dto.response.CustomerDto;
import com.mth.spring.mvc.ordermanagement.dto.response.CustomerSummaryDto;
import com.mth.spring.mvc.ordermanagement.model.Customer;

public class CustomerMapper {

  public static CustomerDto toCustomerDto(Customer customer) {
    if (customer == null) {
      return null;
    }
    return new CustomerDto(
        customer.getId(),
        customer.getFirstName(),
        customer.getLastName(),
        customer.getEmail(),
        customer.getPhoneNumber());
  }

  public static CustomerSummaryDto toCustomerSummaryDto(Customer customer) {
    if (customer == null) {
      return null;
    }
    return new CustomerSummaryDto(
        customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getEmail());
  }
}

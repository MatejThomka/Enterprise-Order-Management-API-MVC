package com.mth.spring.mvc.ordermanagement.mapper;

import com.mth.spring.mvc.ordermanagement.dto.request.CreateCustomerRequest;
import com.mth.spring.mvc.ordermanagement.dto.request.UpdateCustomerRequest;
import com.mth.spring.mvc.ordermanagement.dto.response.CustomerDto;
import com.mth.spring.mvc.ordermanagement.dto.response.CustomerSummaryDto;
import com.mth.spring.mvc.ordermanagement.model.Customer;

/** CustomerMapper class for mapping Customer entity from and into dto's */
public class CustomerMapper {

  /**
   * Converts a Customer entity to a CustomerDto.
   *
   * @param customer the Customer entity to convert
   * @return the corresponding CustomerDto
   */
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

  /**
   * Converts a Customer entity to a CustomerSummaryDto.
   *
   * @param customer the Customer entity to convert
   * @return the corresponding CustomerSummaryDto
   */
  public static CustomerSummaryDto toCustomerSummaryDto(Customer customer) {
    if (customer == null) {
      return null;
    }
    return new CustomerSummaryDto(
        customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getEmail());
  }

  /**
   * Converts a CreateCustomerRequest to a Customer entity.
   *
   * @param request the CreateCustomerRequest to convert
   * @param email the email address for the new customer
   * @return the corresponding Customer entity
   */
  public static Customer toEntity(CreateCustomerRequest request, String email) {
    return new Customer(request.firstName(), request.lastName(), email, request.phoneNumber());
  }

  /**
   * Updates a Customer entity with data from an UpdateCustomerRequest.
   *
   * @param customer the Customer entity to update
   * @param request the UpdateCustomerRequest containing the updated data
   */
  public static Customer updateEntity(Customer customer, UpdateCustomerRequest request) {
    customer.setFirstName(request.firstName());
    customer.setLastName(request.lastName());
    customer.setPhoneNumber(request.phoneNumber());
    return customer;
  }
}

package com.mth.spring.mvc.ordermanagement.service;

import com.mth.spring.mvc.ordermanagement.dto.request.CreateCustomerRequest;
import com.mth.spring.mvc.ordermanagement.dto.response.CustomerDto;
import com.mth.spring.mvc.ordermanagement.dto.response.CustomerSummaryDto;
import com.mth.spring.mvc.ordermanagement.mapper.CustomerMapper;
import com.mth.spring.mvc.ordermanagement.model.Customer;
import com.mth.spring.mvc.ordermanagement.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Service class for managing customer-related operations. */
@Service
@Transactional
public class CustomerService {

  private final CustomerRepository customerRepository;

  /**
   * Constructs a CustomerService with the given CustomerRepository.
   *
   * @param customerRepository the repository for customer data access
   */
  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  /**
   * Retrieves a customer by their ID.
   *
   * @param id the ID of the customer to retrieve
   * @return the CustomerDto representing the customer
   * @throws IllegalArgumentException if the ID is null
   * @throws EntityNotFoundException if the customer is not found
   */
  @Transactional(readOnly = true)
  public CustomerDto getCustomerById(Long id)
      throws IllegalArgumentException, EntityNotFoundException {
    if (id == null) {
      throw new IllegalArgumentException("Customer ID cannot be null");
    }

    return customerRepository
        .findById(id)
        .map(CustomerMapper::toCustomerDto)
        .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + id));
  }

  /**
   * Retrieves a summary of a customer by their ID.
   *
   * @param id the ID of the customer to retrieve
   * @return the CustomerSummaryDto representing the customer summary
   * @throws IllegalArgumentException if the ID is null
   * @throws EntityNotFoundException if the customer is not found
   */
  @Transactional(readOnly = true)
  public CustomerSummaryDto getCustomerSummaryById(Long id)
      throws IllegalArgumentException, EntityNotFoundException {
    if (id == null) {
      throw new IllegalArgumentException("Customer ID cannot be null");
    }

    return customerRepository
        .findById(id)
        .map(CustomerMapper::toCustomerSummaryDto)
        .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + id));
  }

  /**
   * Saves a new customer based on the provided CreateCustomerRequest.
   *
   * @param request the request containing customer details
   * @return the CustomerSummaryDto of the saved customer
   * @throws IllegalArgumentException if the request is invalid
   * @throws IllegalStateException if a customer with the same email already exists
   */
  public CustomerSummaryDto createCustomer(CreateCustomerRequest request)
      throws IllegalArgumentException, IllegalStateException {
    String email = request.email().toLowerCase().trim();

    if (customerRepository.existsByEmail(email)) {
      throw new IllegalStateException("Customer already exists with email: " + email);
    }

    Customer customer = CustomerMapper.toEntity(request, email);

    return CustomerMapper.toCustomerSummaryDto(customerRepository.save(customer));
  }
}

package com.mth.spring.mvc.ordermanagement.controller;

import com.mth.spring.mvc.ordermanagement.dto.response.CustomerDto;
import com.mth.spring.mvc.ordermanagement.dto.response.CustomerSummaryDto;
import com.mth.spring.mvc.ordermanagement.dto.response.Response;
import com.mth.spring.mvc.ordermanagement.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for managing customer-related endpoints.
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

  private final CustomerService customerService;

  /**
   * Constructs a CustomerController with the given CustomerService.
   *
   * @param customerService the service for customer-related operations
   */
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  /**
   * @GetMapping("/{id}")
   * Retrieves a customer by their ID.
   * 
   * @param id the ID of the customer to retrieve
   * @return the Response containing CustomerDto
   */
  @GetMapping("/{id}")
  public Response<CustomerDto> getCustomerById(@PathVariable Long id) {
    return Response.of(HttpStatus.OK.value(), customerService.getCustomerById(id));
  }

  /**
   * @GetMapping("/summary/{id}")
   * Retrieves a summary of a customer by their ID.
   * 
   * @param id the ID of the customer summary to retrieve
   * @return the Response containing CustomerSummaryDto
   */
  @GetMapping("/summary/{id}")
  public Response<CustomerSummaryDto> getCustomerSummary(@PathVariable Long id) {
      return Response.of(HttpStatus.OK.value(), customerService.getCustomerSummaryById(id));
  }

  
}

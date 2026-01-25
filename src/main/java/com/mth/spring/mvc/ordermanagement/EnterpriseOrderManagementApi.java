package com.mth.spring.mvc.ordermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Enterprise Order Management API. This is a Spring Boot application
 * that provides REST API endpoints for managing orders, customers, and items.
 */
@SpringBootApplication
public class EnterpriseOrderManagementApi {

  /**
   * Main method to start the Spring Boot application.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(EnterpriseOrderManagementApi.class, args);
  }
}

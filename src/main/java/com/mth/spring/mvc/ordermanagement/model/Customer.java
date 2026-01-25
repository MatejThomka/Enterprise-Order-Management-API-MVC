package com.mth.spring.mvc.ordermanagement.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity representing a customer in the order management system. Customers can have multiple orders
 * associated with them.
 */
@Entity
@Table(name = "customers")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String lastName;

  @NotNull
  @Email
  @Column(nullable = false, unique = true)
  private String email;

  private String phoneNumber;

  @Column(nullable = false, updatable = false)
  private Instant createdAt;

  private Instant updatedAt;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Order> orders = new ArrayList<>();

  protected Customer() {}

  /**
   * Constructor for creating a new customer.
   *
   * @param firstName the customer's first name
   * @param lastName the customer's last name
   * @param email the customer's email address
   * @param phoneNumber the customer's phone number (optional)
   */
  public Customer(String firstName, String lastName, String email, String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  @PrePersist
  protected void onCreate() {
    this.createdAt = Instant.now();
    this.updatedAt = Instant.now();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = Instant.now();
  }

  /**
   * Get the unique identifier of the customer.
   *
   * @return the customer ID
   */
  public Long getId() {
    return id;
  }

  /**
   * Get the first name of the customer.
   *
   * @return the first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Get the last name of the customer.
   *
   * @return the last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Get the email address of the customer.
   *
   * @return the email address
   */
  public String getEmail() {
    return email;
  }

  /**
   * Get the phone number of the customer.
   *
   * @return the phone number
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * Get the timestamp when the customer was created.
   *
   * @return the creation timestamp
   */
  public Instant getCreatedAt() {
    return createdAt;
  }

  /**
   * Get the timestamp when the customer was last updated.
   *
   * @return the last update timestamp
   */
  public Instant getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Get the list of orders associated with the customer.
   *
   * @return the list of orders
   */
  public List<Order> getOrders() {
    return orders;
  }

  /**
   * Set the first name of the customer.
   *
   * @param firstName the first name to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Set the last name of the customer.
   *
   * @param lastName the last name to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Set the email address of the customer.
   *
   * @param email the email address to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Set the phone number of the customer.
   *
   * @param phoneNumber the phone number to set
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * Adds an order to this customer's list of orders. Also sets the customer reference in the order.
   *
   * @param order the order to add
   * @throws IllegalArgumentException if order is null
   */
  public void addOrder(Order order) {
    if (order == null) {
      throw new IllegalArgumentException("Order must not be null");
    }
    orders.add(order);
    order.setCustomer(this);
  }

  /**
   * Removes an order from this customer's list of orders. Also clears the customer reference in the
   * order.
   *
   * @param order the order to remove
   */
  public void removeOrder(Order order) {
    orders.remove(order);
    order.setCustomer(null);
  }
}

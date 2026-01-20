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

  private Instant udpateAt;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Order> orders = new ArrayList<>();

  protected Customer() {}

  public Customer(String firstName, String lastName, String email, String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  @PrePersist
  protected void onCreate() {
    this.createdAt = Instant.now();
    this.udpateAt = Instant.now();
  }

  @PreUpdate
  protected void onUpdate() {
    this.udpateAt = Instant.now();
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPhoneNumebr() {
    return phoneNumber;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdateAt() {
    return udpateAt;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void addOrder(Order order) {
    orders.add(order);
    order.setCustomer(this);
  }

  public void removeOrder(Order order) {
    orders.remove(order);
    order.setCustomer(null);
  }
}

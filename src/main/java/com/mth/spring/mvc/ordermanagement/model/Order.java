package com.mth.spring.mvc.ordermanagement.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity representing an order in the order management system. Orders belong to customers and
 * contain multiple items.
 */
@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String orderNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id", nullable = false)
  private Customer customer;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private OrderStatus status;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Item> items = new ArrayList<>();

  @Column(nullable = false, updatable = false)
  private Instant createdAt;

  private Instant updatedAt;

  protected Order() {}

  /**
   * Constructor for creating a new order.
   *
   * @param orderNumber the unique order number
   * @param customer the customer who placed the order
   * @param status the current status of the order
   */
  public Order(String orderNumber, Customer customer, OrderStatus status) {
    this.orderNumber = orderNumber;
    this.customer = customer;
    this.status = status;
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
   * Get the unique identifier of the order.
   *
   * @return the order ID
   */
  public Long getId() {
    return id;
  }

  /**
   * Get the unique order number.
   *
   * @return the order number
   */
  public String getOrderNumber() {
    return orderNumber;
  }

  /**
   * Get the customer who placed the order.
   *
   * @return the customer
   */
  public Customer getCustomer() {
    return customer;
  }

  /**
   * Get the current status of the order.
   *
   * @return the order status
   */
  public OrderStatus getStatus() {
    return status;
  }

  /**
   * Get the list of items in the order.
   *
   * @return the list of items
   */
  public List<Item> getItems() {
    return items;
  }

  /**
   * Get the creation timestamp of the order.
   *
   * @return the creation timestamp
   */
  public Instant getCreatedAt() {
    return createdAt;
  }

  /**
   * Get the last updated timestamp of the order.
   *
   * @return the last updated timestamp
   */
  public Instant getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Set the unique order number.
   *
   * @param orderNumber the order number to set
   */
  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  /**
   * Set the customer who placed the order.
   *
   * @param customer the customer to set
   */
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  /**
   * Set the current status of the order.
   *
   * @param status the order status to set
   */
  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  /**
   * Add an item to the order.
   *
   * @param item the item to add
   */
  public void addItem(Item item) {
    items.add(item);
    item.setOrder(this);
  }

  /**
   * Remove an item from the order.
   *
   * @param item the item to remove
   */
  public void removeItem(Item item) {
    items.remove(item);
    item.setOrder(null);
  }
}

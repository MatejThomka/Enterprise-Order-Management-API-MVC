package com.mth.spring.mvc.ordermanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;

/**
 * Entity representing an item in an order. Items belong to orders and have a name, description, and
 * price.
 */
@Entity
@Table(name = "items")
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(nullable = false)
  String name;

  @Column(nullable = false)
  String description;

  @Column(nullable = false)
  BigDecimal price;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id", nullable = false)
  Order order;

  protected Item() {}

  /**
   * Constructor for creating a new item.
   *
   * @param name the name of the item
   * @param description the description of the item
   * @param price the price of the item
   */
  public Item(String name, String description, BigDecimal price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }

  /**
   * Get the unique identifier of the item.
   *
   * @return the item ID
   */
  public Long getId() {
    return id;
  }

  /**
   * Get the name of the item.
   *
   * @return the item name
   */
  public String getName() {
    return name;
  }

  /**
   * Get the description of the item.
   *
   * @return the item description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Get the price of the item.
   *
   * @return the item price
   */
  public BigDecimal getPrice() {
    return price;
  }

  /**
   * Get the order associated with the item.
   *
   * @return the order
   */
  public Order getOrder() {
    return order;
  }

  /**
   * Set the name of the item.
   *
   * @param name the item name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Set the description of the item.
   *
   * @param description the item description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Set the price of the item.
   *
   * @param price the item price
   */
  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  /**
   * Set the order associated with the item.
   *
   * @param order the order
   */
  public void setOrder(Order order) {
    this.order = order;
  }
}

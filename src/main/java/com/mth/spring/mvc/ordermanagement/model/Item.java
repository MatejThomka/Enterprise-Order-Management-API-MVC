package com.mth.spring.mvc.ordermanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import org.springframework.data.annotation.Id;

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

  BigDecimal price;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id")
  Order order;

  protected Item() {}

  public Item(String name, String description, BigDecimal price, Order order) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.order = order;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String description() {
    return description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public Order getOrder() {
    return order;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setOrder(Order order) {
    this.order = order;
  }
}

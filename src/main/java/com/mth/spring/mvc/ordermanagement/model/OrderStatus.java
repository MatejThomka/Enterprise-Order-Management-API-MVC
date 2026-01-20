package com.mth.spring.mvc.ordermanagement.model;

public enum OrderStatus {
  RECEIVED("received"),
  CONFIRMED("confirmed"),
  PREPARING("preparing"),
  PACKAGING("packaging"),
  SENT("sent");

  private final String value;

  OrderStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return value;
  }
}

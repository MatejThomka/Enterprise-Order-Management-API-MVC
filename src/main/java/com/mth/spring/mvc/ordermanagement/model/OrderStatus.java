package com.mth.spring.mvc.ordermanagement.model;

/** Enumeration representing the possible statuses of an order. */
public enum OrderStatus {
  RECEIVED("received"),
  CONFIRMED("confirmed"),
  PREPARING("preparing"),
  PACKAGING("packaging"),
  SENT("sent"),
  CANCELED("canceled"),
  DELIVERED("delivered");

  private final String value;

  /**
   * Constructor for OrderStatus.
   *
   * @param value the string value of the status
   */
  OrderStatus(String value) {
    this.value = value;
  }

  /**
   * Gets the string value of the status.
   *
   * @return the string value
   */
  public String getValue() {
    return value;
  }

  /**
   * Returns the string representation of the status.
   *
   * @return the string value
   */
  @Override
  public String toString() {
    return value;
  }
}

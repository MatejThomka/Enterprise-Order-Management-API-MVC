package com.mth.spring.mvc.ordermanagement.mapper;

import static com.mth.spring.mvc.ordermanagement.mapper.CustomerMapper.toCustomerSummaryDto;
import static com.mth.spring.mvc.ordermanagement.mapper.ItemMapper.toItemListDtoList;

import com.mth.spring.mvc.ordermanagement.dto.request.CreateOrderRequest;
import com.mth.spring.mvc.ordermanagement.dto.response.OrderDto;
import com.mth.spring.mvc.ordermanagement.dto.response.OrderListDto;
import com.mth.spring.mvc.ordermanagement.model.Order;
import java.util.List;

/** Mapper class for converting Order entities to DTOs */
public class OrderMapper {

  /**
   * Converts an Order entity to an OrderDto.
   *
   * @param order the Order entity to convert
   * @return the corresponding OrderDto
   */
  public static OrderDto toOrderDto(Order order) {
    if (order == null) {
      return null;
    }
    return new OrderDto(
        order.getOrderNumber(),
        order.getStatus(),
        toCustomerSummaryDto(order.getCustomer()),
        toItemListDtoList(order.getItems()),
        order.getCreatedAt());
  }

  /**
   * Converts an Order entity to an OrderListDto.
   *
   * @param order the Order entity to convert
   * @return the corresponding OrderListDto
   */
  public static OrderListDto toOrderListDto(Order order) {
    if (order == null) {
      return null;
    }
    return new OrderListDto(order.getOrderNumber(), order.getStatus(), order.getCreatedAt());
  }

  /**
   * Converts a list of Order entities to a list of OrderDto.
   *
   * @param orders the list of Order entities to convert
   * @return the corresponding list of OrderDto
   */
  public static List<OrderDto> toOrderDtoList(List<Order> orders) {
    return orders.stream().map(OrderMapper::toOrderDto).toList();
  }

  /**
   * Converts a list of Order entities to a list of OrderListDto.
   *
   * @param orders the list of Order entities to convert
   * @return the corresponding list of OrderListDto
   */
  public static List<OrderListDto> toOrderListDtoList(List<Order> orders) {
    return orders.stream().map(OrderMapper::toOrderListDto).toList();
  }

  /**
   * Converts a CreateOrderRequest to an Order entity.
   * @param orderNumber the unique order number
   * @param request the CreateOrderRequest to convert
   * @return the corresponding Order entity
   */
  public static Order toEntity(String orderNumber, CreateOrderRequest request) {
    return new Order(
        orderNumber,
        request.customer() != null ? CustomerMapper.toEntity(request.customer(), request.customer().email()) : null,
        request.items().stream().map(ItemMapper::toEntity).toList());
  }
}

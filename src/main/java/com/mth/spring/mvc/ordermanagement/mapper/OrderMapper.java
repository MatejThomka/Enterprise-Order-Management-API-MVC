package com.mth.spring.mvc.ordermanagement.mapper;

import static com.mth.spring.mvc.ordermanagement.mapper.CustomerMapper.toCustomerSummaryDto;
import static com.mth.spring.mvc.ordermanagement.mapper.ItemMapper.toItemListDtoList;

import com.mth.spring.mvc.ordermanagement.dto.OrderDto;
import com.mth.spring.mvc.ordermanagement.dto.OrderListDto;
import com.mth.spring.mvc.ordermanagement.model.Order;
import java.util.List;

public class OrderMapper {

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

  public static OrderListDto toOrderListDto(Order order) {
    if (order == null) {
      return null;
    }
    return new OrderListDto(order.getOrderNumber(), order.getStatus(), order.getCreatedAt());
  }

  public static List<OrderDto> toOrderDtoList(List<Order> orders) {
    return orders.stream().map(OrderMapper::toOrderDto).toList();
  }

  public static List<OrderListDto> toOrderListDtoList(List<Order> orders) {
    return orders.stream().map(OrderMapper::toOrderListDto).toList();
  }
}

package com.mth.spring.mvc.ordermanagement.service;

import com.mth.spring.mvc.ordermanagement.dto.request.CreateOrderRequest;
import com.mth.spring.mvc.ordermanagement.dto.response.OrderDto;
import com.mth.spring.mvc.ordermanagement.dto.response.OrderListDto;
import com.mth.spring.mvc.ordermanagement.mapper.OrderMapper;
import com.mth.spring.mvc.ordermanagement.model.Order;
import com.mth.spring.mvc.ordermanagement.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;

import java.time.Instant;
import java.util.List;
import org.springframework.data.domain.Pageable;

public class OrderService {

  private final OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public OrderDto getOrderById(String orderNumber) {
    return orderRepository
        .findByOrderNumber(orderNumber)
        .map(OrderMapper::toOrderDto)
        .orElseThrow(() -> new EntityNotFoundException("Order not found with orderNumber: " + orderNumber));
  }

  public OrderListDto getOrderListById(String orderNumber) {
    return orderRepository
        .findByOrderNumber(orderNumber)
        .map(OrderMapper::toOrderListDto)
        .orElseThrow(() -> new EntityNotFoundException("Order not found with orderNumber: " + orderNumber));
  }

  public List<OrderDto> getAllOrders(Long id, Pageable pageable) {
    return OrderMapper.toOrderDtoList(orderRepository.findAllByCustomerId(id, pageable).getContent());
  }

  public List<OrderListDto> getAllOrderLists(Long id, Pageable pageable) {
    return OrderMapper.toOrderListDtoList(orderRepository.findAllByCustomerId(id, pageable).getContent());
  }

  public OrderDto createOrder(CreateOrderRequest orderRequest) {
    String orderNumber = generateOrderNumber();

    Order order = OrderMapper.toEntity(orderNumber, orderRequest);

    return OrderMapper.toOrderDto(orderRepository.save(order));
  }

  public OrderDto updateOrder(Long id, OrderDto orderDto) {
    Order existingOrder =
        orderRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));

    existingOrder.setStatus(orderDto.status());

    return OrderMapper.toOrderDto(orderRepository.save(existingOrder));
  }

  public void deleteOrder(Long id) {
    // Implementation goes here
  }

  private String generateOrderNumber() {
    return Instant.now().toString();
  }
}

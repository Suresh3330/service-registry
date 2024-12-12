package com.programming.order_service.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programming.order_service.dto.OrderLineItemsDto;
import com.programming.order_service.dto.OrderRequest;
import com.programming.order_service.model.Order;
import com.programming.order_service.model.OrderLineItems;
import com.programming.order_service.repository.OrderRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

	 private final OrderRepository orderRepository;
	 
	 public Order placeOrder(OrderRequest orderRequest) {
	        Order order = new Order();
	        order.setOrederNumber(UUID.randomUUID().toString());

	        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
	                .stream()
	                .map(this::mapToDto)
	                .collect(Collectors.toList());

	        order.setOrderLineItemsList(orderLineItems);
	        orderRepository.save(order);
			return order;
}
	 
	 private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
	        OrderLineItems orderLineItems = new OrderLineItems();
	        orderLineItems.setPrice(orderLineItemsDto.getPrice());
	        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
	        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
	        return orderLineItems;
}
}

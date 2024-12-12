package com.programming.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programming.order_service.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

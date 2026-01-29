package com.example.demo.service;

import com.example.demo.repository.OrderRepository;
import com.example.demo.entity.Order;
import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.enums.OrderStatus;
import com.example.demo.dto.CreateOrderRequest;


import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Service
public class OrderServiceImpl implements OrderService {
    
    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
    
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }


    @Override
    public String getOrder(int id) {
        return orderRepository.findById(id)
                .map(order -> "Order fetched with id " + order.getId())
                .orElseThrow(() -> new OrderNotFoundException("Order not found" + id));
    }

    @Override
    public String createOrder(CreateOrderRequest request) {
        Order order = new Order();
        log.info("Creating new order with status {}", request.getStatus());

        order.setStatus(OrderStatus.CREATED);
        //order.setStatus(request.getStatus());

        Order savedOrder = orderRepository.save(order);
        log.info("Order created successfully with id {}", savedOrder.getId());

        return "Order created with id " + savedOrder.getId();

    }

}



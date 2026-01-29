package com.example.demo.service;

import com.example.demo.dto.CreateOrderRequest;

public interface OrderService {
    String getOrder(int id);
    String createOrder(CreateOrderRequest request);
}


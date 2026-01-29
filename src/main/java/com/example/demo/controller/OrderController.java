package com.example.demo.controller;

import com.example.demo.dto.CreateOrderRequest;


import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.OrderService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;


@RestController
public class OrderController {
    private final OrderService orderService;
    
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/orders/{id}")
    public String getOrder(@PathVariable int id){
        return orderService.getOrder(id);
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello from backend!";
    }

    @PostMapping("/orders")
    public String createOrder(@Valid @RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }
}

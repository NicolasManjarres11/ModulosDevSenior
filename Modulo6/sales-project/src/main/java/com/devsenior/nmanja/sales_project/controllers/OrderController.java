package com.devsenior.nmanja.sales_project.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.sales_project.models.entities.Order;
import com.devsenior.nmanja.sales_project.services.OrderServices;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    public final OrderServices orderServices;

    @GetMapping
    public List<Order> getOrders() {
        return orderServices.getAllOrders();
    }
    
    
}

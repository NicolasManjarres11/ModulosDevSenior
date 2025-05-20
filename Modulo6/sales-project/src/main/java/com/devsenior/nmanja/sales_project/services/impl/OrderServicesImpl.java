package com.devsenior.nmanja.sales_project.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.nmanja.sales_project.models.entities.Order;
import com.devsenior.nmanja.sales_project.repositories.OrderRepository;
import com.devsenior.nmanja.sales_project.services.OrderServices;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class OrderServicesImpl implements OrderServices{

    private final OrderRepository orderRepository;
 
        @Override
        public List<Order> getAllOrders() {
            return orderRepository.findAll();
        }

}

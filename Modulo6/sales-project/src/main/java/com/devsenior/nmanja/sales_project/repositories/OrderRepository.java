package com.devsenior.nmanja.sales_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.nmanja.sales_project.models.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{


}

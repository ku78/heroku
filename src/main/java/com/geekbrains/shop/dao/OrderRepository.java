package com.example.demo.dao;

import com.example.demo.domain.Cart;
import com.example.demo.domain.Order;
import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOneById(Long id);
}

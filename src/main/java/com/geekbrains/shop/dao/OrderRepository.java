package com.geekbrains.shop.dao;

import com.geekbrains.shop.entities.Cart;
import com.geekbrains.shop.entities.Order;
import com.geekbrains.shop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOneById(Long id);
}

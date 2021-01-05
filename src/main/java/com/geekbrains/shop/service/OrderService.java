package com.geekbrains.shop.service;

import com.geekbrains.shop.entities.Order;
import com.geekbrains.shop.entities.User;
import com.geekbrains.shop.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto getOrderDtoById(Long id);
}

package com.geekbrains.shop.service;

import com.geekbrains.shop.dao.OrderRepository;
import com.geekbrains.shop.entities.*;
import com.geekbrains.shop.dto.OrderDto;
import com.geekbrains.shop.mapper.OrderDetailsMapper;
import com.geekbrains.shop.mapper.OrderMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDetailsMapper orderDetailsMapper = OrderDetailsMapper.MAPPER;
    private final OrderMapper orderMapper = OrderMapper.MAPPER;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto getOrderDtoById(Long id) {
        Order order = orderRepository.findOneById(id);
        OrderDto orderDto = orderMapper.fromOrder(order);
        orderDto.setUsername(order.getUser().getName());
        orderDto.aggregate();
        return orderDto;
    }
}

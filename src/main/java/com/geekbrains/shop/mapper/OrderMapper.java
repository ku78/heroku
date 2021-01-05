package com.geekbrains.shop.mapper;

import com.geekbrains.shop.entities.Order;
import com.geekbrains.shop.entities.OrderDetails;
import com.geekbrains.shop.dto.OrderDetailsDto;
import com.geekbrains.shop.dto.OrderDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);

    Order toOrder(OrderDto orderDto);

    @InheritInverseConfiguration
    OrderDto fromOrder(Order order);

    List<Order> toOrder(List<OrderDto> orderDtos);

    List<OrderDto> fromOrder(List<Order> order);
}

package com.geekbrains.shop.mapper;

import com.geekbrains.shop.entities.OrderDetails;
import com.geekbrains.shop.entities.User;
import com.geekbrains.shop.dto.OrderDetailsDto;
import com.geekbrains.shop.dto.UserDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderDetailsMapper {

    OrderDetailsMapper MAPPER = Mappers.getMapper(OrderDetailsMapper.class);

    OrderDetails toOrderDetails(OrderDetailsDto orderDetailsDto);

    @InheritInverseConfiguration
    OrderDetailsDto fromOrderDetails(OrderDetails orderDetails);

    List<OrderDetails> toOrderDetails(List<OrderDetailsDto> orderDetailsDtos);

    List<OrderDetailsDto> fromOrderDetails(List<OrderDetails> orderDetails);
}

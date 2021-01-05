package com.geekbrains.shop.dto;

import com.geekbrains.shop.entities.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private long id;
    private LocalDateTime created;
    private String username;
    private double sum;
    private long amount;
    private OrderStatus status;
    private List<OrderDetailsDto> details = new ArrayList<>();

    public void aggregate(){
        this.amount = details.size();
    }
}

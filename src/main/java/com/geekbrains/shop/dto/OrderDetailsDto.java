package com.geekbrains.shop.dto;

import com.geekbrains.shop.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailsDto {
    private String title;
    private Product product;
    private Double price;
    private Double amount;
}

package com.geekbrains.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MethodLogDetails {
    private LocalDateTime time;
    private Class stringClass;
    private String stringMethod;
}

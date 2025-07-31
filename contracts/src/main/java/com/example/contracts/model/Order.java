package com.example.contracts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private Long id;
    private Long userId;
    private Double orderAmount;
    private String currency;
    private List<String> itemsOrder;
}

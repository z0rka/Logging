package com.example.logging.coffee.order;

import lombok.*;

/**
 * @author z0rka 03.02.2023;
 * Object of the order
 */
@Data
@AllArgsConstructor
public class Order {
    private String customerName;
    private int number;
}

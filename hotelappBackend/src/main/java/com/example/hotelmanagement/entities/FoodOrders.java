package com.example.hotelmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrders {
    private Long foodOrderId;
    private Long roomId;
    private Long foodItemId;
    private int quantity;
    private double price;   
}

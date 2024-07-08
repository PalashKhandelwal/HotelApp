package com.example.hotelmanagement.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItems {
    private Long foodItemId;
    private String foodItemName;
    private double price;
}

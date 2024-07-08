package com.example.hotelmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "food_items")

public class FoodItemsEntity {
    @Id
    private Long foodItemId;
    private String foodItemName;
    private double price;
}

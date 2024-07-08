package com.example.hotelmanagement.services;

import java.util.List;
import com.example.hotelmanagement.entities.FoodItems;

public interface FoodItemsService {
    String addFoodItems(FoodItems foodItems);
    List<FoodItems> getFoodDetails();
    boolean deleteFoodItem(Long foodItemId);
    String updateFoodItem(Long foodItemId, FoodItems foodItems);
}

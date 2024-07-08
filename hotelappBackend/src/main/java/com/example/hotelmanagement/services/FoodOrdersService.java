package com.example.hotelmanagement.services;
import java.util.List;
import com.example.hotelmanagement.entities.FoodOrders;

public interface FoodOrdersService {
    String createFoodOrder(FoodOrders foodOrders);
    List<FoodOrders> getAllOrders();
    FoodOrders getSingleOrder(Long foodItemId);
    boolean cancelFoodOrder(Long foodItemId);
}

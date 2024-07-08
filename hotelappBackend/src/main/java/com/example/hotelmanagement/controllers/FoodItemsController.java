package com.example.hotelmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.hotelmanagement.entities.FoodItems;
import com.example.hotelmanagement.services.FoodItemsService;

@RestController
public class FoodItemsController {
    
    @Autowired
    FoodItemsService foodService;

    @GetMapping("getAllFood")
    public List<FoodItems> getFoodList(){
        return foodService.getFoodDetails();
    }

    @PostMapping("addFood")
    public String addFood(@RequestBody FoodItems foodItems){
        return foodService.addFoodItems(foodItems);
    }

    @DeleteMapping("delete/{id}")
    public String deleteFood(@PathVariable Long id){
        if(foodService.deleteFoodItem(id)){
            return "Food Deleted";
        }else{
            return "Not Found!";
        }
    }
    @PutMapping("updateFood/{id}")
    public String updateFood(@PathVariable Long id, @RequestBody FoodItems foodItems){
        return foodService.updateFoodItem(id, foodItems);
    }

}

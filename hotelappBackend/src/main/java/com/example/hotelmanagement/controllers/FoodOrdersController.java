package com.example.hotelmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.hotelmanagement.entities.FoodOrders;
import com.example.hotelmanagement.services.FoodOrdersService;

@RestController
public class FoodOrdersController {
    
    @Autowired
    FoodOrdersService foodOrdersService;

    @GetMapping("getAllOrders")
    public List<FoodOrders> getOrders(){
        return foodOrdersService.getAllOrders();
    }

    @GetMapping("getSingle/{id}")
    public FoodOrders getSingleOrder(@PathVariable Long id){
        return foodOrdersService.getSingleOrder(id);
    }

    @PostMapping("order")
    public String orderFood(@RequestBody FoodOrders food){
        return foodOrdersService.createFoodOrder(food);
    }

    @DeleteMapping("deleteOrder/{id}")
    public String deleteFoodOrder(@PathVariable Long id){
        if(foodOrdersService.cancelFoodOrder(id)){
            return "Order Canceled!";
        }else{
            return "No Orders made yet";
        }
    }

}

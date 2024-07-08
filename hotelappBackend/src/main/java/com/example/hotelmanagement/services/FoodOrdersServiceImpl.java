package com.example.hotelmanagement.services;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelmanagement.entities.FoodOrders;
import com.example.hotelmanagement.entities.FoodOrdersEntity;
import com.example.hotelmanagement.repositories.FoodOrdersRepository;
import java.util.*;

@Service
public class FoodOrdersServiceImpl implements FoodOrdersService {
    
    @Autowired
    FoodOrdersRepository foodOrderRepo;

    @Override
    public String createFoodOrder(FoodOrders foodOrders){
        FoodOrdersEntity foodEn = new FoodOrdersEntity();
        foodEn.setFoodOrderId(foodOrders.getFoodOrderId());
        foodEn.setRoomId(foodOrders.getRoomId());
        foodEn.setFoodItemId(foodOrders.getFoodItemId());
        foodEn.setQuantity(foodOrders.getQuantity());
        foodEn.setPrice(foodOrders.getPrice());

        foodOrderRepo.save(foodEn);

        return "Food Order created successfully";
    }

    @Override
    public List<FoodOrders> getAllOrders(){
        List<FoodOrdersEntity> foodEntity = foodOrderRepo.findAll();
        List<FoodOrders> food = new ArrayList<>();
        for(FoodOrdersEntity fe : foodEntity){
            FoodOrders fo = new FoodOrders();
            fo.setFoodOrderId(fe.getFoodOrderId());
            fo.setRoomId(fe.getRoomId());
            fo.setFoodItemId(fe.getFoodItemId());
            fo.setQuantity(fe.getQuantity());
            fo.setPrice(fe.getPrice());
            food.add(fo);
        }
        return food;
    }

    @Override
    public FoodOrders getSingleOrder(Long id){
        Optional<FoodOrdersEntity> foodEnt = foodOrderRepo.findById(id);
        FoodOrders food = new FoodOrders();
        if(foodEnt.isPresent()){   
            FoodOrdersEntity foodE = foodEnt.get();
            BeanUtils.copyProperties(foodE, food);
            return food;
        }else{
            return null;
        }
    }
    @Override
    public boolean cancelFoodOrder(Long id){
        Optional<FoodOrdersEntity> foe = foodOrderRepo.findById(id);
        if(foe.isPresent()){
            FoodOrdersEntity food = foe.get();
            foodOrderRepo.delete(food);
            return true;
        }else{
            return false;
        }
    }
}

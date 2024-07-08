package com.example.hotelmanagement.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.hotelmanagement.entities.FoodItems;
import com.example.hotelmanagement.entities.FoodItemsEntity;
import com.example.hotelmanagement.repositories.FoodItemsRepository;

@Service
public class FoodItemServiceImpl implements FoodItemsService{
    
    @Autowired
    FoodItemsRepository foodRepo;

    @Override
    public String addFoodItems(FoodItems foodItems){
        FoodItemsEntity foodEntity = new FoodItemsEntity();
        foodEntity.setFoodItemId(foodItems.getFoodItemId());
        foodEntity.setFoodItemName(foodItems.getFoodItemName());
        foodEntity.setPrice(foodItems.getPrice());
        foodRepo.save(foodEntity);
        return "New Food Added";
    }

    public List<FoodItems> getFoodDetails(){
        List<FoodItemsEntity> foodEn = foodRepo.findAll();
        List<FoodItems> foodIt = new ArrayList<>();
        for(FoodItemsEntity f : foodEn){
            FoodItems fi = new FoodItems();
            fi.setFoodItemId(f.getFoodItemId());
            fi.setFoodItemName(f.getFoodItemName());
            fi.setPrice(f.getPrice());
            foodIt.add(fi);
        }
        return foodIt;
    }

    public boolean deleteFoodItem(Long foodItemId){
        Optional<FoodItemsEntity> fo = foodRepo.findById(foodItemId);
        if(fo.isPresent()){
            FoodItemsEntity fe = fo.get();
            foodRepo.delete(fe);
            return true;
        }else{
            return false;
        }
    }

    public String updateFoodItem(Long foodItemId, FoodItems foodItems) {
        Optional<FoodItemsEntity> optionalFoodEntity = foodRepo.findById(foodItemId);
        if (optionalFoodEntity.isPresent()) {
            FoodItemsEntity foodEntity = optionalFoodEntity.get();
            foodEntity.setFoodItemName(foodItems.getFoodItemName());
            foodEntity.setPrice(foodItems.getPrice());
            foodRepo.save(foodEntity);
            return "Updated Successfully";
        } else {
            return "Not Found!";
        }
    }
}

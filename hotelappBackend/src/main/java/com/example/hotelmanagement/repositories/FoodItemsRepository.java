package com.example.hotelmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotelmanagement.entities.FoodItemsEntity;

public interface FoodItemsRepository extends JpaRepository<FoodItemsEntity, Long> {

} 
package com.example.hotelmanagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "food_orders")
@Data
@NoArgsConstructor
public class FoodOrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "food_order_id")
    private Long foodOrderId;

    @Column(name = "room_id", nullable = false)
    private Long roomId;

    @Column(name = "food_item_id", nullable = false)
    private Long foodItemId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private double price;
}

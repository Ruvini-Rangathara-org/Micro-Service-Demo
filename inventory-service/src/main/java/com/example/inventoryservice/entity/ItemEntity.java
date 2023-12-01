package com.example.inventoryservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: ruu
 * Created: 2023-11-24 10.53
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "item")
public class ItemEntity {
    @Id
    private String code;
    private String description;
    private double unitPrice;
    private int qtyOnHand;
}

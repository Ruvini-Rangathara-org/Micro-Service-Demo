package com.example.inventoryservice.dto;

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
public class ItemDTO {
    private String code;
    private String description;
    private double unitPrice;
    private int qtyOnHand;

}

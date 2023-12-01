package com.example.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: ruu
 * Created: 2023-12-01 09.27
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemUserDTO {
    private String code;
    private String description;
    private double unitPrice;
    private int qtyOnHand;

    private String username;
    private String password;
    private String name;
    private int age;

}

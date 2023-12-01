package com.example.inventoryservice.repository;


import com.example.inventoryservice.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: ruu
 * Created: 2023-11-24 10.54
 */

public interface ItemRepo extends JpaRepository<ItemEntity,String> {
}

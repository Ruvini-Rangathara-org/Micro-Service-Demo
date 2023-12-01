package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.ItemDTO;

import java.util.List;

/**
 * Author: ruu
 * Created: 2023-11-24 10.54
 */


public interface ItemService {
    boolean save(ItemDTO itemDTO);
    boolean update(ItemDTO itemDTO);
    boolean delete(String code);
    ItemDTO search(String code);
    boolean existsByCode(String code);
    List<ItemDTO> findAll();

}

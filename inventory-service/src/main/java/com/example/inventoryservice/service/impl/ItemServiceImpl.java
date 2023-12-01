package com.example.inventoryservice.service.impl;

import com.example.inventoryservice.dto.ItemDTO;
import com.example.inventoryservice.entity.ItemEntity;
import com.example.inventoryservice.repository.ItemRepo;
import com.example.inventoryservice.service.ItemService;
import com.example.inventoryservice.util.mapper.Convertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: ruu
 * Created: 2023-11-24 10.54
 */

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    Convertor convertor;

    @Autowired
    ItemRepo itemRepo;

    @Override
    public boolean save(ItemDTO itemDTO) {
        itemRepo.save(convertor.getItemEntity(itemDTO));
        return true;
    }

    @Override
    public boolean update(ItemDTO itemDTO) {
        itemRepo.save(convertor.getItemEntity(itemDTO));
        return true;
    }

    @Override
    public boolean delete(String code) {
        if(itemRepo.existsById(code)){
            ItemEntity itemEntity = new ItemEntity();
            itemEntity.setCode(code);
            itemRepo.delete(itemEntity);
            return true;
        }else {
            throw new RuntimeException("Item does not exists!");
        }
    }

    @Override
    public ItemDTO search(String code) {
        if(itemRepo.existsById(code)){
            return convertor.getItemDTO(itemRepo.getReferenceById(code));
        }else throw new RuntimeException("User does not exists!");
    }

    @Override
    public boolean existsByCode(String code) {
        return itemRepo.existsById(code);
    }

    @Override
    public List<ItemDTO> findAll() {
        List<ItemDTO> list = new ArrayList<>();
        List<ItemEntity> all = itemRepo.findAll();
        for (ItemEntity id: all) {
            list.add(convertor.getItemDTO(id));
        }
        return list;
    }
}

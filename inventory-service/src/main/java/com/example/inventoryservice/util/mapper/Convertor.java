package com.example.inventoryservice.util.mapper;

import com.example.inventoryservice.dto.ItemDTO;
import com.example.inventoryservice.entity.ItemEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Author: ruu
 * Created: 2023-11-24 10.54
 */

@Component
public class Convertor {
    private final ModelMapper modelMapper;

    public Convertor(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ItemDTO getItemDTO(ItemEntity itemEntity){
        return modelMapper.map(itemEntity, ItemDTO.class);
    }

    public ItemEntity getItemEntity(ItemDTO itemDTO){
        return modelMapper.map(itemDTO, ItemEntity.class);
    }

}

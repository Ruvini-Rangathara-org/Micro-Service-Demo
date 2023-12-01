package com.example.userservice.util.mapper;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: ruu
 * Created: 2023-11-24 09.53
 */


@Component
public class Convertor {
    @Autowired
    private final ModelMapper modelMapper;


    public Convertor(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDTO getUserDTO (UserEntity userEntity){
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public UserEntity getUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }
}

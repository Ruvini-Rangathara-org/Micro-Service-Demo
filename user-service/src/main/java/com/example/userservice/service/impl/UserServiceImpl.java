package com.example.userservice.service.impl;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.repository.UserRepo;
import com.example.userservice.service.UserService;
import com.example.userservice.util.mapper.Convertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: ruu
 * Created: 2023-11-24 10.08
 */

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    Convertor convertor;

    @Autowired
    UserRepo userRepo;

    @Override
    public boolean save(UserDTO userDTO) {
        userRepo.save(convertor.getUserEntity(userDTO));
        return true;
    }

    @Override
    public boolean update(UserDTO userDTO) {
        userRepo.save(convertor.getUserEntity(userDTO));
        return true;
    }

    @Override
    public boolean delete(String username) {
        if(userRepo.existsById(username)){
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(username);
            userRepo.delete(userEntity);
            return true;
        }else {
            throw new RuntimeException("User does not exists!");
        }
    }

    @Override
    public UserDTO search(String username) {
        if(userRepo.existsById(username)){
            return convertor.getUserDTO(userRepo.getReferenceById(username));
        }else throw new RuntimeException("User does not exists!");
    }

    @Override
    public boolean existById(String username) {
        return userRepo.existsById(username);
    }

    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> list = new ArrayList<>();
        List<UserEntity> all = userRepo.findAll();
        for (UserEntity ud: all) {
            list.add(convertor.getUserDTO(ud));
        }
        return list;
    }

}

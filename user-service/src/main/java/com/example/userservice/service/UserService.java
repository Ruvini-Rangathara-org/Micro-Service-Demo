package com.example.userservice.service;

import com.example.userservice.dto.UserDTO;

import java.util.List;

/**
 * Author: ruu
 * Created: 2023-11-24 10.09
 */

public interface UserService  {

    boolean save(UserDTO userDTO);
    boolean update(UserDTO userDTO);
    boolean delete(String username);
    UserDTO search(String username);
    boolean existById(String username);

    List<UserDTO> getAll();

}

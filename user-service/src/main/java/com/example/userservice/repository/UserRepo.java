package com.example.userservice.repository;

import com.example.userservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Author: ruu
 * Created: 2023-11-24 10.07
 */

public interface UserRepo extends JpaRepository<UserEntity, String> {
}

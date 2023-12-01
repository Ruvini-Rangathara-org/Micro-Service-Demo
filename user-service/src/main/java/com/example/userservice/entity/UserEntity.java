package com.example.userservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: ruu
 * Created: 2023-11-24 09.52
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "user")
public class UserEntity {
    @Id
    private String username;
    private String password;
    private String name;
    private int age;

}

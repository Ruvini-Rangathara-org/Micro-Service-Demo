package com.example.userservice.controller;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: ruu
 * Created: 2023-11-24 09.52
 */

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:63342")
public class UserAPI {

    private final UserService userService;

    public UserAPI(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/save")
    public void save() {
        System.out.println("Success");
    }

    @PostMapping(value = "/save2", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO) {
        if (userService.existById(userDTO.getUsername())) {
            System.out.println("exists");
            return ResponseEntity.badRequest().body("User already exists!");
        }
        userService.save(userDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestPart("user") UserDTO userDTO) {
        if (!userService.existById(userDTO.getUsername())) {
            System.out.println("not exists");
            return ResponseEntity.badRequest().body("User does not exists!");
        }
        userService.save(userDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> delete(@RequestHeader("username") String username) {
        if (!userService.existById(username)) {
            System.out.println("not exists");
            return ResponseEntity.badRequest().body("User does not exists!");
        }
        userService.delete(username);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/find")
    public ResponseEntity<?> findUser(@PathVariable String username) {
        if (!userService.existById(username)) {
            System.out.println("not exists");
            return ResponseEntity.badRequest().body("User does not exists!");
        }
        userService.search(username);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() {
        List<UserDTO> all = userService.getAll();

        System.out.println(all.size());
        for (UserDTO userDTO : all) {
            System.out.println(userDTO.getUsername());
        }
        if (all.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return a 204 No Content response
        }
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/check/")
    public ResponseEntity<?> existsByUsername(@RequestHeader String username) {
        boolean isExists = userService.existById(username);
        if (isExists) return ResponseEntity.ok(true);
        return ResponseEntity.ok().body(false);
    }

}

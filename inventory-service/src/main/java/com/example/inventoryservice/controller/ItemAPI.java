package com.example.inventoryservice.controller;

import com.example.inventoryservice.dto.ItemDTO;
import com.example.inventoryservice.dto.ItemUserDTO;
import com.example.inventoryservice.dto.UserDTO;
import com.example.inventoryservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Author: ruu
 * Created: 2023-11-24 10.53
 */


@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin(origins = "http://localhost:63342")
public class ItemAPI {
    private final ItemService itemService;

    public ItemAPI(ItemService itemService) {
        this.itemService = itemService;
    }

    @Autowired
    private RestTemplate restTemplate;


    //call user api using rest template
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody ItemUserDTO itemUserDTO) {
//
//        if (itemService.existsByCode(itemUserDTO.getCode())) {
//            System.out.println("Item exists");
//            return ResponseEntity.badRequest().body("Item already exists!");
//        }
//
//        ItemDTO itemDTO = new ItemDTO(itemUserDTO.getCode(), itemUserDTO.getDescription(),
//                itemUserDTO.getUnitPrice(), itemUserDTO.getQtyOnHand());
//        boolean saveItem = itemService.save(itemDTO);
//
//        if (saveItem) {
//            System.out.println("Item saved");
//
//            UserDTO userDTO = new UserDTO(itemUserDTO.getUsername(), itemUserDTO.getPassword(),
//                    itemUserDTO.getName(), itemUserDTO.getAge());
//
//            ResponseEntity<String> userApiResponse = restTemplate.postForEntity(
//                    "http://localhost:8080/api/v1/user/save", userDTO, String.class);
//
//            if (userApiResponse.getStatusCode().is2xxSuccessful()) {
//                System.out.println("User saved");
//                return ResponseEntity.ok("Item and User saved successfully");
//            } else {
//                System.out.println("Error saving User: " + userApiResponse.getBody());
//                // Rollback the item save if user save fails (assuming your service supports rollback)
//                itemService.delete(itemUserDTO.getCode());
//                return ResponseEntity.status(userApiResponse.getStatusCode())
//                        .body("Error saving User: " + userApiResponse.getBody());
//            }
//        }
//
//        System.out.println("Item not saved");
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body("Item not saved");

        return null;
    }

    @PostMapping(value = "/save2", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save (@RequestBody ItemDTO itemDTO){
        if(itemService.existsByCode(itemDTO.getCode())){
            System.out.println("exists");
            return ResponseEntity.badRequest().body("Item already exists!");
        }
        itemService.save(itemDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update (@RequestPart ("item") ItemDTO itemDTO){
        if(!itemService.existsByCode(itemDTO.getCode())){
            System.out.println("not exists");
            return ResponseEntity.badRequest().body("Item does not exists!");
        }
        itemService.save(itemDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> delete(@RequestHeader("code") String code){
        if(!itemService.existsByCode(code)){
            System.out.println("not exists");
            return ResponseEntity.badRequest().body("Item does not exists!");
        }
        itemService.delete(code);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/find")
    public ResponseEntity<?> findItem(@RequestHeader("code") String code){

//        if(!itemService.existsByCode(code)){
//            System.out.println("not exists");
//            return ResponseEntity.badRequest().body("Item does not exists!");
//        }
//
//        // URI template with 'U0001' as a variable
//        String uriTemplate = "http://localhost:8080/api/v1/user/find/{U0001}";
//
//// Provide a value for 'U0001'
//        String u0001Value = "U0001";
//
//// Use UriComponentsBuilder to expand variables
//        URI uri = UriComponentsBuilder.fromUriString(uriTemplate)
//                .buildAndExpand(u0001Value)
//                .toUri();
//
//// Make the request
//        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
//
////        String forObject = restTemplate.getForObject("http://localhost:8080/api/v1/user/find?username={U0001}", String.class);
////        System.out.println(forObject);
//        ItemDTO search = itemService.search(code);
//        System.out.println("Searched : "+search.getCode());
//        return ResponseEntity.ok().build();
        return null;
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll(){
        List<ItemDTO> all = itemService.findAll();

        System.out.println(all.size());
        for (ItemDTO itemDTO : all) {
            System.out.println(itemDTO.getCode());
        }
        if (all.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return a 204 No Content response
        }
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/check/")
    public ResponseEntity<?> existsByItemCode(@RequestHeader String code) {
        boolean isExists = itemService.existsByCode(code);
        if (isExists) return ResponseEntity.ok(true);
        return ResponseEntity.ok().body(false);
    }

}

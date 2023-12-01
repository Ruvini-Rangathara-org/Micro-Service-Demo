package com.example.inventoryservice.util.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: ruu
 * Created: 2023-11-24 10.54
 */

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper (){
        return new ModelMapper();
    }

}

package com.example.phoneaccessoryshop.config;

import com.cloudinary.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Config {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Cloudinary getCloudinary() {

        Map config = new HashMap<String, String>();

        config.put("cloud_name", "dng1qd54f");
        config.put("api_key", "976847789855999");
        config.put("api_secret", "KK25xS5a2EJ1KxY3mzazh0avtAg");
        config.put("secure", "true");

        return new Cloudinary(config);
    }


}

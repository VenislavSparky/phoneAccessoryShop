package com.example.phoneaccessoryshop.config;

import com.example.phoneaccessoryshop.model.entity.RoleEntity;
import com.example.phoneaccessoryshop.model.enums.UserRoleEnum;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Config {


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}

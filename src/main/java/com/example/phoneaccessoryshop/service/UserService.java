package com.example.phoneaccessoryshop.service;

import com.example.phoneaccessoryshop.model.dto.UserRegistrationDTO;
import com.example.phoneaccessoryshop.model.entity.UserEntity;
import org.springframework.stereotype.Service;


public interface UserService {
    boolean registerUser(UserRegistrationDTO userRegistrationDTO);

    UserEntity findByName(String name);
}

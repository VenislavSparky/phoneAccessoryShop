package com.example.phoneaccessoryshop.service;

import com.example.phoneaccessoryshop.model.dto.UserRegistrationDTO;
import org.springframework.stereotype.Service;


public interface UserService {
    void registerUser(UserRegistrationDTO userRegistrationDTO);
}

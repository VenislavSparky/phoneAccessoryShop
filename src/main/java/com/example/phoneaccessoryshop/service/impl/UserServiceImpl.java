package com.example.phoneaccessoryshop.service.impl;

import com.example.phoneaccessoryshop.model.dto.UserRegistrationDTO;
import com.example.phoneaccessoryshop.model.entity.UserEntity;
import com.example.phoneaccessoryshop.repository.UserRepository;
import com.example.phoneaccessoryshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    private void registerUser(UserRegistrationDTO userRegistrationDTO) {
        UserEntity user = modelMapper.map(userRegistrationDTO, UserEntity.class);

        if (!userRegistrationDTO.password().equals(userRegistrationDTO.confirmPassword())) {
            throw new IllegalArgumentException("The passwords doesnt match!");
        }

        user.setActive(true);
        user.setPassword(passwordEncoder.encode(userRegistrationDTO.password()));
        userRepository.save(user);

    }

}
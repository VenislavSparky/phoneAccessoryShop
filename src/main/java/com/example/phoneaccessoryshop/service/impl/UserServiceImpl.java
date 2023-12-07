package com.example.phoneaccessoryshop.service.impl;

import com.example.phoneaccessoryshop.model.dto.UserRegistrationDTO;
import com.example.phoneaccessoryshop.model.entity.UserEntity;
import com.example.phoneaccessoryshop.model.enums.UserRoleEnum;
import com.example.phoneaccessoryshop.model.events.UserRegisteredEvent;
import com.example.phoneaccessoryshop.repository.RoleRepository;
import com.example.phoneaccessoryshop.repository.UserRepository;
import com.example.phoneaccessoryshop.service.UserService;
import com.example.phoneaccessoryshop.service.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final ApplicationEventPublisher appEventPublisher;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, ApplicationEventPublisher appEventPublisher) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.appEventPublisher = appEventPublisher;
    }

    public boolean registerUser(UserRegistrationDTO userRegistrationDTO) {

        if (!userRegistrationDTO.getPassword().equals(userRegistrationDTO.getConfirmPassword())) {
            throw new IllegalArgumentException("Password mismatch!");
        }

        UserEntity user = modelMapper.map(userRegistrationDTO, UserEntity.class);

        user.setActive(false);
        user.setRoles(List.of(roleRepository.findRoleByRole(UserRoleEnum.USER)));
        user.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));

        userRepository.save(user);

        appEventPublisher.publishEvent(new UserRegisteredEvent("UserService", userRegistrationDTO.getEmail(), userRegistrationDTO.fullName()));

        return true;
    }

    @Override
    public UserEntity findByName(String name) {
        return userRepository.findByEmail(name).orElseThrow(() -> new ObjectNotFoundException("User not found!"));
    }

    @Override
    public void createUserIfNotExist(String email, String name) {

    }

    @Override
    public Authentication login(String email) {
        return null;
    }

}

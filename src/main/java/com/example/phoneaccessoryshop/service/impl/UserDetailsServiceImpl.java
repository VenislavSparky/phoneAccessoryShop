package com.example.phoneaccessoryshop.service.impl;

import com.example.phoneaccessoryshop.model.entity.UserEntity;
import com.example.phoneaccessoryshop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;


public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).map(this::map).orElseThrow(() -> new UsernameNotFoundException("Username " + email + " not found!"));
    }

    private UserDetails map(UserEntity userEntity) {
      return User.withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(List.of())
                .build();
    }
}

package com.example.phoneaccessoryshop.service.impl;

import com.example.phoneaccessoryshop.model.entity.RoleEntity;
import com.example.phoneaccessoryshop.model.entity.UserEntity;
import com.example.phoneaccessoryshop.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(UserDetailsServiceImpl::map)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + email + " not found!"));
    }

    private static UserDetails map(UserEntity userEntity) {
      return User.withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(userEntity.getRoles().stream().map(UserDetailsServiceImpl::map).toList())
                .build();
    }

    private static GrantedAuthority map(RoleEntity roleEntity){
        return new SimpleGrantedAuthority("ROLE_"+ roleEntity.getRole().name());
    }

}

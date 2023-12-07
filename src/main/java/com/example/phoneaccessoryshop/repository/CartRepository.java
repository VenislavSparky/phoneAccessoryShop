package com.example.phoneaccessoryshop.repository;

import com.example.phoneaccessoryshop.model.entity.CartEntity;
import com.example.phoneaccessoryshop.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {
    CartEntity findByUser(UserEntity user);

}

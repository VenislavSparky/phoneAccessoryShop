package com.example.phoneaccessoryshop.service;

import com.example.phoneaccessoryshop.model.dto.CartViewDTO;
import com.example.phoneaccessoryshop.model.entity.ProductEntity;
import com.example.phoneaccessoryshop.model.entity.UserEntity;

import java.util.UUID;

public interface CartService {
    void addCartItem(ProductEntity product, UserEntity user);

    void removeCartItem(ProductEntity product, UserEntity user);

    CartViewDTO getUserCart(UserEntity user);


}
